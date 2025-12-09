package Lab7.poly.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Lab7.poly.JDBC.Jdbc;
import Lab7.poly.entity.Department;

public class DepartmentDAOIpml implements DepartmentDAO {

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM Departments";
        List<Department> list = new ArrayList<>();

        try (ResultSet rs = Jdbc.executeQuery(sql)) {
            while (rs.next()) {
                Department d = new Department();
                d.setId(rs.getString("Id"));
                d.setName(rs.getString("Name"));
                d.setDescription(rs.getString("Description"));
                list.add(d);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error at findAll()", e);
        }

        return list;
    }

    @Override
    public Department findById(String id) {
        String sql = "SELECT * FROM Departments WHERE Id=?";

        try (ResultSet rs = Jdbc.executeQuery(sql, id)) {
            if (rs.next()) {
                Department d = new Department();
                d.setId(rs.getString("Id"));
                d.setName(rs.getString("Name"));
                d.setDescription(rs.getString("Description"));
                return d;
            }
            return null; // Không ném lỗi lung tung
        } catch (Exception e) {
            throw new RuntimeException("Error at findById()", e);
        }
    }

    @Override
    public void create(Department entity) {
        String sql = "INSERT INTO Departments (Id, Name, Description) VALUES (?, ?, ?)";

        try {
            Jdbc.executeUpdate(sql,
                entity.getId().trim(),
                entity.getName(),
                entity.getDescription()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error at create()", e);
        }
    }

    @Override
    public void update(Department entity) {
        String sql = "UPDATE Departments SET Name=?, Description=? WHERE Id=?";

        try {
            Jdbc.executeUpdate(sql,
                entity.getName(),
                entity.getDescription(),
                entity.getId().trim()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error at update()", e);
        }
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM Departments WHERE Id=?";

        try {
            Jdbc.executeUpdate(sql, id.trim());
        } catch (Exception e) {
            throw new RuntimeException("Error at deleteById()", e);
        }
    }
}
