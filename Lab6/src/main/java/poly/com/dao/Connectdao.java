package poly.com.dao;

import java.sql.*;

public class Connectdao {

    // Kết nối tĩnh
    protected static Connection conn;

    // Constructor mở kết nối
    public Connectdao() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=lab6_java3_csdl;encrypt=false";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, "sa", "123");
            System.out.println("Kết nối thành công!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // =======================
    // 1. HÀM SELECT (trả về ResultSet)
    // =======================
    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            if (conn == null || conn.isClosed()) {
                new Connectdao(); // mở lại kết nối
            }

            PreparedStatement ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // =======================
    // 2. HÀM INSERT – UPDATE – DELETE
    // =======================
    public static int executeUpdate(String sql, Object... args) {
        try {
            if (conn == null || conn.isClosed()) {
                new Connectdao();
            }

            PreparedStatement ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
