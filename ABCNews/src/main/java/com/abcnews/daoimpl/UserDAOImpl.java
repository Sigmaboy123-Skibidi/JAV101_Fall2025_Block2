package com.abcnews.daoimpl;

import com.abcnews.dao.UserDAO;
import com.abcnews.entity.User;
import com.abcnews.util.DBUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> findAll() throws Exception {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection c = DBUtils.getConnection();
             PreparedStatement p = c.prepareStatement(sql);
             ResultSet rs = p.executeQuery()) {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getString("Id"));
                u.setPassword(rs.getString("Password"));
                u.setFullname(rs.getString("Fullname"));
                u.setBirthday(rs.getDate("Birthday"));
                u.setGender(rs.getBoolean("Gender"));
                u.setMobile(rs.getString("Mobile"));
                u.setEmail(rs.getString("Email"));
                u.setRole(rs.getBoolean("Role"));
                list.add(u);
            }
        }
        return list;
    }

    @Override
    public User findById(String id) throws Exception {
        String sql = "SELECT * FROM Users WHERE Id=?";
        try (Connection c = DBUtils.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, id);
            try (ResultSet rs = p.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setId(rs.getString("Id"));
                    u.setPassword(rs.getString("Password"));
                    u.setFullname(rs.getString("Fullname"));
                    u.setBirthday(rs.getDate("Birthday"));
                    u.setGender(rs.getBoolean("Gender"));
                    u.setMobile(rs.getString("Mobile"));
                    u.setEmail(rs.getString("Email"));
                    u.setRole(rs.getBoolean("Role"));
                    return u;
                }
            }
        }
        return null;
    }

    @Override
    public User login(String id, String password) throws Exception {
        String sql = "SELECT * FROM Users WHERE Id=? AND Password=?";
        try (Connection c = DBUtils.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, id);
            p.setString(2, password);
            try (ResultSet rs = p.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setId(rs.getString("Id"));
                    u.setPassword(rs.getString("Password"));
                    u.setFullname(rs.getString("Fullname"));
                    u.setBirthday(rs.getDate("Birthday"));
                    u.setGender(rs.getBoolean("Gender"));
                    u.setMobile(rs.getString("Mobile"));
                    u.setEmail(rs.getString("Email"));
                    u.setRole(rs.getBoolean("Role"));
                    return u;
                }
            }
        }
        return null;
    }

    @Override
    public void insert(User u) throws Exception {
        String sql = "INSERT INTO Users(Id, Password, Fullname, Birthday, Gender, Mobile, Email, Role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = DBUtils.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
        	 p.setString(1, u.getId());
             p.setString(2, u.getPassword());
             p.setString(3, u.getFullname());
             p.setDate(4, u.getBirthday());
             p.setObject(5, u.getGender(), Types.BOOLEAN); // tránh default false
             p.setString(6, u.getMobile());
             p.setString(7, u.getEmail());
             p.setObject(8, u.getRole(), Types.BOOLEAN);
            p.executeUpdate();
        }
    }

    @Override
    public void update(User u) throws Exception {
        String sql = "UPDATE Users SET Password=?, Fullname=?, Birthday=?, Gender=?, Mobile=?, Email=?, Role=? WHERE Id=?";
        try (Connection c = DBUtils.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
        	p.setString(1, u.getPassword());
            p.setString(2, u.getFullname());
            p.setDate(3, u.getBirthday());
            p.setObject(4, u.getGender(), Types.BOOLEAN);
            p.setString(5, u.getMobile());
            p.setString(6, u.getEmail());
            p.setObject(7, u.getRole(), Types.BOOLEAN);
            p.setString(8, u.getId());
            p.executeUpdate();
        }
    }

    @Override
    public void delete(String id) throws Exception {
        String sql = "DELETE FROM Users WHERE Id=?";
        try (Connection c = DBUtils.getConnection();
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, id);
            p.executeUpdate();
        }
    }
}
