package poly.com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab6_B3_Departments {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=lab6_java3_csdl;encrypt=false;trustServerCertificate=true;";
    static String username = "sa";
    static String password = "123";

    static {
        try { 
            Class.forName(driver); // nạp driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /** Mở kết nối */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, username, password);
    }

    /** Thao tác INSERT, UPDATE, DELETE */
    public static int executeUpdate(String sql) throws SQLException {
        try (
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
        ) {
            return statement.executeUpdate(sql);
        }
    }

    /** Truy vấn SELECT */
    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
        // Caller sẽ đóng connection sau khi đọc ResultSet
    }

    public static void main(String[] args) {
        // =================== SELECT Departments ===================
        try {
            System.out.println("Truy vấn tất cả Departments:");
            String sql = "SELECT id, Name, Description FROM Departments";
            ResultSet rs = Lab6_B3_Departments.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                System.out.println(id + " - " + name + " - " + description);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // =================== INSERT Department ===================
        try {
            System.out.println("Insert dữ liệu:");
            String sql = "INSERT INTO Departments (id, Name, Description) " +
                         "VALUES ('006', N'Marketing', N'Marketing Department')";
            int rows = Lab6_B3_Departments.executeUpdate(sql);
            System.out.println("Số dòng thêm: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // =================== UPDATE Department ===================
        try {
            System.out.println("Update dữ liệu:");
            String sql = "UPDATE Departments SET Name = N'Marketing Updated', Description = N'Updated Department' " +
                         "WHERE id = '006'";
            int rows = Lab6_B3_Departments.executeUpdate(sql);
            System.out.println("Số dòng cập nhật: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
