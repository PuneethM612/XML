package com.bnpp.pb.lynx.service;

import com.bnpp.pb.lynx.model.ExamType;
import com.bnpp.pb.lynx.model.Marks;
import com.bnpp.pb.lynx.model.StudentRanking;
import java.util.List;

public interface MarksService {
    
    Marks getMarksById(Long markId);
    
    List<Marks> getMarksByStudentAndExamType(String rollNumber, ExamType examType);
    
    List<Marks> getAllMarks();
    
    void addMarks(Marks marks);
    
    void updateMarks(Marks marks);
    
    void removeMarks(Long markId);
    
    List<StudentRanking> getTopRankers(ExamType examType, int limit);
} 