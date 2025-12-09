package poly.com.dao;

import java.sql.*;
import java.util.*;

import poly.com.model.Employee;

public class EmployeeDAO {

    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM EMPLOYEES";
            ResultSet rs = Connectdao.executeQuery(sql);  // ✔ ĐÃ CHẠY ĐƯỢC

            while (rs != null && rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getString("Id"));
                e.setPassword(rs.getString("Password"));
                e.setFullname(rs.getString("Fullname"));
                e.setPhoto(rs.getString("Photo"));
                e.setGender(rs.getBoolean("Gender"));
                e.setBirthday(rs.getDate("Birthday"));
                e.setSalary(rs.getDouble("Salary"));
                e.setDepartmentId(rs.getString("DepartmentId"));
                list.add(e);
            }

            rs.getStatement().getConnection().close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
