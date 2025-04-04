package com.bnpp.pb.lynx.dao;

import com.bnpp.pb.lynx.model.Subject;
import java.util.List;

public interface SubjectDao {
    
    Subject findById(Long subjectId);
    
    List<Subject> findAll();
    
    void save(Subject subject);
    
    void update(Subject subject);
    
    void delete(Long subjectId);
} 