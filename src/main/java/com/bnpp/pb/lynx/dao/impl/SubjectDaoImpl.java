package com.bnpp.pb.lynx.dao.impl;

import com.bnpp.pb.lynx.dao.SubjectDao;
import com.bnpp.pb.lynx.model.Subject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Subject findById(Long subjectId) {
        String sql = "SELECT * FROM subject WHERE subject_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{subjectId}, new SubjectRowMapper());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Subject> findAll() {
        String sql = "SELECT * FROM subject";
        return jdbcTemplate.query(sql, new SubjectRowMapper());
    }

    @Override
    public void save(Subject subject) {
        String sql = "INSERT INTO subject (subject_id, subject_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, subject.getSubjectId(), subject.getSubjectName());
    }

    @Override
    public void update(Subject subject) {
        String sql = "UPDATE subject SET subject_name = ? WHERE subject_id = ?";
        jdbcTemplate.update(sql, subject.getSubjectName(), subject.getSubjectId());
    }

    @Override
    public void delete(Long subjectId) {
        String sql = "DELETE FROM subject WHERE subject_id = ?";
        jdbcTemplate.update(sql, subjectId);
    }

    private static class SubjectRowMapper implements RowMapper<Subject> {
        @Override
        public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
            Subject subject = new Subject();
            subject.setSubjectId(rs.getLong("subject_id"));
            subject.setSubjectName(rs.getString("subject_name"));
            return subject;
        }
    }
} 