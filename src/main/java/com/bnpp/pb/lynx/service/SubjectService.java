package com.bnpp.pb.lynx.service;

import com.bnpp.pb.lynx.model.Subject;
import java.util.List;

public interface SubjectService {
    
    Subject getSubjectById(Long subjectId);
    
    List<Subject> getAllSubjects();
    
    void addSubject(Subject subject);
    
    void updateSubject(Subject subject);
    
    void removeSubject(Long subjectId);
} 