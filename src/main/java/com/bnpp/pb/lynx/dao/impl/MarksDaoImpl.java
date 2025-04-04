package com.bnpp.pb.lynx.dao.impl;

import com.bnpp.pb.lynx.dao.MarksDao;
import com.bnpp.pb.lynx.model.ExamType;
import com.bnpp.pb.lynx.model.Marks;
import com.bnpp.pb.lynx.model.StudentRanking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MarksDaoImpl implements MarksDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Marks findById(Long markId) {
        String sql = "SELECT * FROM marks WHERE mark_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{markId}, new MarksRowMapper());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Marks> findByRollNumberAndExamType(String rollNumber, ExamType examType) {
        String sql = "SELECT * FROM marks WHERE roll_number = ? AND exam_type = ?";
        return jdbcTemplate.query(sql, new Object[]{rollNumber, examType.name()}, new MarksRowMapper());
    }

    @Override
    public List<Marks> findAll() {
        String sql = "SELECT * FROM marks";
        return jdbcTemplate.query(sql, new MarksRowMapper());
    }

    @Override
    public void save(Marks marks) {
        String sql = "INSERT INTO marks (roll_number, exam_type, subject_id, marks) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, 
                marks.getRollNumber(), 
                marks.getExamType().name(), 
                marks.getSubjectId(), 
                marks.getMarks());
    }

    @Override
    public void update(Marks marks) {
        String sql = "UPDATE marks SET marks = ? WHERE mark_id = ?";
        jdbcTemplate.update(sql, marks.getMarks(), marks.getMarkId());
    }

    @Override
    public void delete(Long markId) {
        String sql = "DELETE FROM marks WHERE mark_id = ?";
        jdbcTemplate.update(sql, markId);
    }

    @Override
    public List<StudentRanking> findTopRankers(ExamType examType, int limit) {
        String sql = "SELECT s.roll_number, s.name, SUM(m.marks) as total_marks, ? as exam_type, " +
                "RANK() OVER (ORDER BY SUM(m.marks) DESC) as rank " +
                "FROM student s " +
                "JOIN marks m ON s.roll_number = m.roll_number " +
                "WHERE m.exam_type = ? " +
                "GROUP BY s.roll_number, s.name " +
                "ORDER BY total_marks DESC " +
                "LIMIT ?";
        
        return jdbcTemplate.query(sql, new Object[]{examType.name(), examType.name(), limit}, new StudentRankingRowMapper());
    }

    private static class MarksRowMapper implements RowMapper<Marks> {
        @Override
        public Marks mapRow(ResultSet rs, int rowNum) throws SQLException {
            Marks marks = new Marks();
            marks.setMarkId(rs.getLong("mark_id"));
            marks.setRollNumber(rs.getString("roll_number"));
            marks.setExamType(ExamType.valueOf(rs.getString("exam_type")));
            marks.setSubjectId(rs.getLong("subject_id"));
            marks.setMarks(rs.getInt("marks"));
            return marks;
        }
    }

    private static class StudentRankingRowMapper implements RowMapper<StudentRanking> {
        @Override
        public StudentRanking mapRow(ResultSet rs, int rowNum) throws SQLException {
            StudentRanking ranking = new StudentRanking();
            ranking.setRollNumber(rs.getString("roll_number"));
            ranking.setName(rs.getString("name"));
            ranking.setTotalMarks(rs.getInt("total_marks"));
            ranking.setExamType(ExamType.valueOf(rs.getString("exam_type")));
            ranking.setRank(rs.getInt("rank"));
            return ranking;
        }
    }
} 