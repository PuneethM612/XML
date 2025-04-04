package com.bnpp.pb.lynx.dao;

import com.bnpp.pb.lynx.model.ExamType;
import com.bnpp.pb.lynx.model.Marks;
import com.bnpp.pb.lynx.model.StudentRanking;
import java.util.List;

public interface MarksDao {
    
    Marks findById(Long markId);
    
    List<Marks> findByRollNumberAndExamType(String rollNumber, ExamType examType);
    
    List<Marks> findAll();
    
    void save(Marks marks);
    
    void update(Marks marks);
    
    void delete(Long markId);
    
    List<StudentRanking> findTopRankers(ExamType examType, int limit);
} 