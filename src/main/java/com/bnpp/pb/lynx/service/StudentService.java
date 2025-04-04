package com.bnpp.pb.lynx.service;

import com.bnpp.pb.lynx.model.Student;
import java.util.List;

public interface StudentService {
    
    Student getStudentByRollNumber(String rollNumber);
    
    List<Student> getAllStudents();
    
    void addStudent(Student student);
    
    void updateStudent(Student student);
    
    void removeStudent(String rollNumber);
} 