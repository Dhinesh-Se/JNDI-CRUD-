package com.kgisl.jndicrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kgisl.jndicrud.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDAO {
	 private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    public EmployeeDAO(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO employee (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getAge());
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET name=?, age=? WHERE id=?";
        jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getId());
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT id, name, age FROM employee WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT id, name, age FROM employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setAge(rs.getInt("age"));
            return employee;
        }
    }
}
