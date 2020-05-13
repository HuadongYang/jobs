package com.jobs.dbQuery.api;

import com.jobs.dbQuery.config.DatabaseConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentApi {

    @Autowired
    private DatabaseConnectionService databaseConnectionService;

    private static List<String> tables = new ArrayList<String>() {{
        add("administrative_cases");
        add("civil_cases");
        add("compensation_cases");
        add("criminal_cases");
        add("enforcement_cases");
    }};

    private static String sql = " SELECT content FROM %s WHERE 1=1 ";
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

    private PreparedStatement getPreparedStatement(String sqlString, Connection conn, String table) throws SQLException {
        return conn.prepareStatement(replaceTable(sqlString, table));
    }

    private void appendContent(List<String> results, PreparedStatement pst) throws SQLException {
        ResultSet re = pst.executeQuery();
        while(re.next()) {
            String content = re.getString("content");
            results.add(content);
        }
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
