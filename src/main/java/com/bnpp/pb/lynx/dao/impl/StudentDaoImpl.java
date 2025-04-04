package com.bnpp.pb.lynx.dao.impl;

import com.bnpp.pb.lynx.dao.StudentDao;
import com.bnpp.pb.lynx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student findByRollNumber(String rollNumber) {
        String sql = "SELECT * FROM student WHERE roll_number = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{rollNumber}, new StudentRowMapper());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO student (roll_number, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getRollNumber(), student.getName());
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE student SET name = ? WHERE roll_number = ?";
        jdbcTemplate.update(sql, student.getName(), student.getRollNumber());
    }

    @Override
    public void delete(String rollNumber) {
        String sql = "DELETE FROM student WHERE roll_number = ?";
        jdbcTemplate.update(sql, rollNumber);
    }

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setRollNumber(rs.getString("roll_number"));
            student.setName(rs.getString("name"));
            return student;
        }
    }
} 