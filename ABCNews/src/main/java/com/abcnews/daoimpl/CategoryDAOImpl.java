package com.abcnews.daoimpl;

import com.abcnews.dao.CategoryDAO;
import com.abcnews.entity.Category;
import com.abcnews.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Categories ORDER BY Id";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("Id"));
                c.setName(rs.getString("Name"));
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lấy danh sách Categories thất bại", e);
        }
        return list;
    }

    @Override
    public Category findById(int id) {
        String sql = "SELECT * FROM Categories WHERE Id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("Id"));
                c.setName(rs.getString("Name"));
                return c;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lấy Category theo Id thất bại", e);
        }
        return null;
    }

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO Categories (Name) VALUES (?)";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, category.getName());
            int affected = ps.executeUpdate();

            if (affected == 0) {
                throw new SQLException("Thêm Category thất bại, không có dòng nào bị ảnh hưởng.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    category.setId(generatedKeys.getInt(1));
                    System.out.println("Insert thành công, Id mới = " + category.getId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Thêm Category thất bại", e);
        }
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE Categories SET Name=? WHERE Id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Cập nhật Category thất bại, không có dòng nào bị ảnh hưởng.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Cập nhật Category thất bại", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Categories WHERE Id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Xóa Category thất bại, không có dòng nào bị ảnh hưởng.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Xóa Category thất bại", e);
        }
    }
}
