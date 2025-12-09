package com.abcnews.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=AssignmentNews;encrypt=false";
    private static final String USER = "sa";
    private static final String PASS = "123";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
