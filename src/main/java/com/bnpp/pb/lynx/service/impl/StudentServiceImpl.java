package com.bnpp.pb.lynx.service.impl;

import com.bnpp.pb.lynx.dao.StudentDao;
import com.bnpp.pb.lynx.model.Student;
import com.bnpp.pb.lynx.service.StudentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;
    
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudentByRollNumber(String rollNumber) {
        return studentDao.findByRollNumber(rollNumber);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.save(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    @Transactional
    public void removeStudent(String rollNumber) {
        studentDao.delete(rollNumber);
    }
} 