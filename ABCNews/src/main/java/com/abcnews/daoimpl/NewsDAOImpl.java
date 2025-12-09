package com.abcnews.daoimpl;

import com.abcnews.dao.NewsDAO;
import com.abcnews.entity.News;
import com.abcnews.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAOImpl implements NewsDAO {

    private News map(ResultSet rs) throws Exception {
        News n = new News();
        n.setId(rs.getInt("Id"));
        n.setTitle(rs.getString("Title"));
        n.setImage(rs.getString("Image"));
        n.setContent(rs.getString("Content"));
        n.setPostedDate(rs.getTimestamp("PostedDate"));
        n.setCategoryId(rs.getInt("CategoryId"));
        n.setViewCount(rs.getInt("ViewCount"));
        return n;
    }

    @Override
    public List<News> findAll() {
        List<News> list = new ArrayList<>();
        String sql = "SELECT * FROM News ORDER BY Id DESC";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) list.add(map(rs));

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public News findById(int id) {
        String sql = "SELECT * FROM News WHERE Id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return map(rs);

        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public void insert(News n) {
        String sql = "INSERT INTO News (Title, Image, Content, CategoryId, PostedDate, ViewCount) VALUES (?, ?, ?, ?, GETDATE(), 0)";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, n.getTitle());
            ps.setString(2, n.getImage());
            ps.setString(3, n.getContent());
            ps.setInt(4, n.getCategoryId());
            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void update(News n) {
        String sql = "UPDATE News SET Title=?, Image=?, Content=?, CategoryId=? WHERE Id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, n.getTitle());
            ps.setString(2, n.getImage());
            ps.setString(3, n.getContent());
            ps.setInt(4, n.getCategoryId());
            ps.setInt(5, n.getId());
            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM News WHERE Id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }
    }

    // ================= HOME PAGE FUNCTIONS =================

    @Override
    public List<News> findLatest() {
        List<News> list = new ArrayList<>();
        String sql = "SELECT TOP 10 * FROM News ORDER BY PostedDate DESC";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) list.add(map(rs));

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public List<News> findByCategory(int categoryId) {
        List<News> list = new ArrayList<>();
        String sql = "SELECT * FROM News WHERE CategoryId=? ORDER BY PostedDate DESC";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) list.add(map(rs));

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void increaseView(int id) {
        String sql = "UPDATE News SET ViewCount = ViewCount + 1 WHERE Id=?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public List<News> findRelatedNews(int categoryId, int excludeId) {
        List<News> list = new ArrayList<>();
        String sql = "SELECT TOP 5 * FROM News WHERE CategoryId=? AND Id<>? ORDER BY PostedDate DESC";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            ps.setInt(2, excludeId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) list.add(map(rs));

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public List<News> findTopView() {
        List<News> list = new ArrayList<>();
        String sql = "SELECT TOP 10 * FROM News ORDER BY ViewCount DESC";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) list.add(map(rs));

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
