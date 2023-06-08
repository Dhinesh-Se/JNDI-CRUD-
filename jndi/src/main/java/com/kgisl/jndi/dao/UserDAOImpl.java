package com.kgisl.jndi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kgisl.jndi.model.User;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> list() {
        String sql = "CALL GetUsers()";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User getById(int id) {
        String sql = "CALL GetUserById(?)";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public void create(User user) {
        String sql = "CALL CreateUser(?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail());
    }

    @Override
    public void update(User user) {
        String sql = "CALL UpdateUser(?, ?, ?)";
        jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql = "CALL DeleteUser(?)";
        jdbcTemplate.update(sql, id);
    }
}