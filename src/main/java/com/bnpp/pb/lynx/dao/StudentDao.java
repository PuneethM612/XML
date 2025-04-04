package com.bnpp.pb.lynx.dao;

import com.bnpp.pb.lynx.model.Student;
import java.util.List;

public interface StudentDao {
    
    Student findByRollNumber(String rollNumber);
    
    List<Student> findAll();
    
    void save(Student student);
    
    void update(Student student);
    
    void delete(String rollNumber);
} 