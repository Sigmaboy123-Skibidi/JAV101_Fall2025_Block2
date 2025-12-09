package com.abcnews.dao;

import com.abcnews.entity.News;
import java.util.List;

public interface NewsDAO {
    List<News> findAll();
    News findById(int id);
    void insert(News news);
    void update(News news);
    void delete(int id);

    // Home page functions
    List<News> findLatest();
    List<News> findByCategory(int categoryId);
    void increaseView(int id);
    List<News> findRelatedNews(int categoryId, int excludeId);
    List<News> findTopView();
}
