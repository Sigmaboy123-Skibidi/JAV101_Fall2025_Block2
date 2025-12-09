package poly.com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;

public class Lab6_B2_Employees {
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
    	try {
    		System.out.println("Truy vấn tất cả Employees"); // Xuất xong xuống dòng
    	    String sql = "SELECT Id, Fullname, Salary, DepartmentId FROM Employees";
    	    ResultSet resultSet = Lab6_B2_Employees.executeQuery(sql);
    	    while (resultSet.next()) {
    	        String id = resultSet.getString("Id");
    	        String fullname = resultSet.getString("Fullname");
    	        double salary = resultSet.getDouble("Salary");
    	        String deptId = resultSet.getString("DepartmentId");
    	        System.out.println(id + " - " + fullname + " - " + salary + " - " + deptId);
    	    }
    	    resultSet.getStatement().getConnection().close();
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	System.out.println("Insert du lieu ");
    	try {
    	    String sql = "INSERT INTO Employees (Id, Password, Fullname, Photo, Gender, Birthday, Salary, DepartmentId) " +
    	                 "VALUES ('E006', 'pass999', N'Lucy Brown', 'lucy.jpg', 0, '1993-11-10', 68000, '001')";
    	    int rows = Lab6_B2_Employees.executeUpdate(sql);
    	    System.out.println("Số dòng thêm: " + rows);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	System.out.println("Update du lieu ");
    	try {
    	    String sql = "UPDATE Employees SET Fullname = N'Lucy Brown Updated', Salary = 70000 WHERE Id = 'E006'";
    	    int rows = Lab6_B2_Employees.executeUpdate(sql);
    	    System.out.println("Số dòng cập nhật: " + rows);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
}
