package com.bnpp.pb.lynx.service.impl;

import com.bnpp.pb.lynx.dao.MarksDao;
import com.bnpp.pb.lynx.model.ExamType;
import com.bnpp.pb.lynx.model.Marks;
import com.bnpp.pb.lynx.model.StudentRanking;
import com.bnpp.pb.lynx.service.MarksService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MarksServiceImpl implements MarksService {

    private MarksDao marksDao;
    
    public void setMarksDao(MarksDao marksDao) {
        this.marksDao = marksDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Marks getMarksById(Long markId) {
        return marksDao.findById(markId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Marks> getMarksByStudentAndExamType(String rollNumber, ExamType examType) {
        return marksDao.findByRollNumberAndExamType(rollNumber, examType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Marks> getAllMarks() {
        return marksDao.findAll();
    }

    @Override
    @Transactional
    public void addMarks(Marks marks) {
        marksDao.save(marks);
    }

    @Override
    @Transactional
    public void updateMarks(Marks marks) {
        marksDao.update(marks);
    }

    @Override
    @Transactional
    public void removeMarks(Long markId) {
        marksDao.delete(markId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentRanking> getTopRankers(ExamType examType, int limit) {
        return marksDao.findTopRankers(examType, limit);
    }
} 