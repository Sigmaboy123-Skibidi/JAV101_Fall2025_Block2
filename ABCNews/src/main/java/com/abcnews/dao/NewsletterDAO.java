package com.abcnews.dao;

import com.abcnews.entity.Newsletter;
import java.util.List;

public interface NewsletterDAO {
    void insert(Newsletter newsletter);
    void delete(int id);
    List<Newsletter> findAll();
}
