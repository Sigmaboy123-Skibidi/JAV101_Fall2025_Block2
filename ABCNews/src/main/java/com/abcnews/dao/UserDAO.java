package com.abcnews.dao;

import com.abcnews.entity.User;
import java.util.List;

public interface UserDAO {
    List<User> findAll() throws Exception;
    User findById(String id) throws Exception;
    User login(String id, String password) throws Exception;
    void insert(User u) throws Exception;
    void update(User u) throws Exception;
    void delete(String id) throws Exception;
}
