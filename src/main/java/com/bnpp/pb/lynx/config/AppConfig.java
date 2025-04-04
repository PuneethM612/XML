package com.bnpp.pb.lynx.config;

import com.bnpp.pb.lynx.dao.MarksDao;
import com.bnpp.pb.lynx.dao.StudentDao;
import com.bnpp.pb.lynx.dao.SubjectDao;
import com.bnpp.pb.lynx.dao.impl.MarksDaoImpl;
import com.bnpp.pb.lynx.dao.impl.StudentDaoImpl;
import com.bnpp.pb.lynx.dao.impl.SubjectDaoImpl;
import com.bnpp.pb.lynx.service.MarksService;
import com.bnpp.pb.lynx.service.StudentService;
import com.bnpp.pb.lynx.service.SubjectService;
import com.bnpp.pb.lynx.service.impl.MarksServiceImpl;
import com.bnpp.pb.lynx.service.impl.StudentServiceImpl;
import com.bnpp.pb.lynx.service.impl.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@Configuration
public class AppConfig {
    
    @Bean
    @ConditionalOnMissingBean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/studentmarks");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }
    
    @Bean
    @ConditionalOnMissingBean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean
    public StudentDao studentDao(JdbcTemplate jdbcTemplate) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.setJdbcTemplate(jdbcTemplate);
        return studentDao;
    }
    
    @Bean
    public SubjectDao subjectDao(JdbcTemplate jdbcTemplate) {
        SubjectDaoImpl subjectDao = new SubjectDaoImpl();
        subjectDao.setJdbcTemplate(jdbcTemplate);
        return subjectDao;
    }
    
    @Bean
    public MarksDao marksDao(JdbcTemplate jdbcTemplate) {
        MarksDaoImpl marksDao = new MarksDaoImpl();
        marksDao.setJdbcTemplate(jdbcTemplate);
        return marksDao;
    }
    
    @Bean
    public StudentService studentService(StudentDao studentDao) {
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentDao(studentDao);
        return studentService;
    }
    
    @Bean
    public SubjectService subjectService(SubjectDao subjectDao) {
        SubjectServiceImpl subjectService = new SubjectServiceImpl();
        subjectService.setSubjectDao(subjectDao);
        return subjectService;
    }
    
    @Bean
    public MarksService marksService(MarksDao marksDao) {
        MarksServiceImpl marksService = new MarksServiceImpl();
        marksService.setMarksDao(marksDao);
        return marksService;
    }
} 