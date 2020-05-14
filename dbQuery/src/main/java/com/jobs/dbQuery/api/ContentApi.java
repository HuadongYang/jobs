package com.jobs.dbQuery.api;

import com.jobs.dbQuery.config.DatabaseConnectionService;
import com.jobs.dbQuery.dto.CaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/content")
public class ContentApi {

    @Autowired
    private DatabaseConnectionService databaseConnectionService;

    private static final String ADMINISTRATIVE_CASES = "administrative_cases";
    private static final String CIVIL_CASES = "civil_cases";
    private static final String COMPENSATION_CASES = "compensation_cases";
    private static final String CRIMINAL_CASES = "criminal_cases";
    private static final String ENFORCEMENT_CASES = "enforcement_cases";

    private static List<String> tables = new ArrayList<String>() {{
        add(ADMINISTRATIVE_CASES);
        add(CIVIL_CASES);
        add(COMPENSATION_CASES);
        add(CRIMINAL_CASES);
        add(ENFORCEMENT_CASES);
    }};

    private static String sql = " SELECT * FROM %s WHERE 1=1 ";
    private static String condition = " and content LIKE CONCAT('%', '%s','%') ";

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<String> queryContent(@RequestParam String key) {
        List<String> keys = dealKey(key);

        String sqlString = replaceKey(keys);
        List<String> results = new ArrayList<>();

        Connection conn = databaseConnectionService.getConnection();

        try {
            for (String table : tables) {
                PreparedStatement pst = getPreparedStatement(sqlString, conn, table);
                appendContent(results, pst);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return results;

    }

    @RequestMapping(value = "/case/category", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> caseCategoryContent() {
        Map<String, List<String>> results = new HashMap<>();

        Connection conn = databaseConnectionService.getConnection();

        try {
            for (String table : tables) {
                PreparedStatement pst = getPreparedStatement(sql, conn, table);
                List<String> contents = new ArrayList<>();
                appendContent(contents, pst);
                switch (table) {
                    case ADMINISTRATIVE_CASES:
                        results.put("行政案件", contents);
                        break;
                    case CIVIL_CASES:
                        results.put("民事案件", contents);
                        break;
                    case COMPENSATION_CASES:
                        results.put("赔偿案件", contents);
                        break;
                    case CRIMINAL_CASES:
                        results.put("刑事案件", contents);
                        break;
                    case ENFORCEMENT_CASES:
                        results.put("执行案件", contents);
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return results;
    }


    @RequestMapping(value = "/time/category", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> timeContent() {

        List<CaseDTO> cases = getCaseDTOS();

        Map<String, List<String>> map = new HashMap<>();
        for (CaseDTO caseDTO : cases) {
            map.computeIfAbsent(caseDTO.getTime(), k -> new ArrayList<>()).add(caseDTO.getContent());
        }
        return map;
    }

    private List<CaseDTO> getCaseDTOS() {
        Connection conn = databaseConnectionService.getConnection();
        List<CaseDTO> cases = new ArrayList<>();
        try {

            for (String table : tables) {
                PreparedStatement pst = getPreparedStatement(sql, conn, table);
                cases.addAll(queryCases(pst));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cases;
    }

    @RequestMapping(value = "/level/category", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> levelContent() {

        List<CaseDTO> cases = getCaseDTOS();

        Map<String, List<String>> map = new HashMap<>();
        for (CaseDTO caseDTO : cases) {
            map.computeIfAbsent(caseDTO.getLevel(), k -> new ArrayList<>()).add(caseDTO.getContent());
        }
        return map;
    }


    private PreparedStatement getPreparedStatement(String sqlString, Connection conn, String table) throws SQLException {
        return conn.prepareStatement(replaceTable(sqlString, table));
    }

    private void appendContent(List<String> results, PreparedStatement pst) throws SQLException {
        ResultSet re = pst.executeQuery();
        while (re.next()) {
            String content = re.getString("content");
            results.add(content);
        }
    }

    private List<CaseDTO> queryCases(PreparedStatement pst) throws SQLException {
        List<CaseDTO> cases = new ArrayList<>();
        ResultSet re = pst.executeQuery();
        while (re.next()) {
            CaseDTO caseDTO = new CaseDTO();
            String content = re.getString("content");
            caseDTO.setContent(content);
            String time = re.getString("time");
            caseDTO.setTime(time);
            String level = re.getString("level");
            caseDTO.setLevel(level);
            cases.add(caseDTO);
        }
        return cases;
    }

    private String replaceTable(String sqlString, String string) {
        return sqlString.replaceAll("%s", string);
    }

    private String replaceKey(List<String> keys) {
        StringBuilder sqls = new StringBuilder(sql);
        for (String x : keys) {
            sqls.append(replaceTable(condition, x));
        }
        return sqls.toString();
    }

    private List<String> dealKey(String key) {
        String[] keys = key.split("\\s+");
        return Arrays.asList(keys);
    }
}
