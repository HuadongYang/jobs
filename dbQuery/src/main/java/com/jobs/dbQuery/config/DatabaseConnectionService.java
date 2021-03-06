package com.jobs.dbQuery.config;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;

@Service
public class DatabaseConnectionService {

    public static final String URL = "jdbc:mysql://127.0.0.1/jobs?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    public static final String NAME = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public Connection getConnection() {
        try {
            Class.forName(NAME);//指定连接类型
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);//获取连接
            return conn;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
