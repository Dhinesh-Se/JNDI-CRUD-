package com.kgisl.jndi.dao;

import java.util.List;

import com.kgisl.jndi.model.User;

public interface UserDAO {
   
    List<User> list();
    
    User getById(int id);
    
    void create(User user);
    
    void update(User user);
    
    void delete(int id);
}