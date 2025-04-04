package com.bnpp.pb.lynx.service.impl;

import com.bnpp.pb.lynx.dao.SubjectDao;
import com.bnpp.pb.lynx.model.Subject;
import com.bnpp.pb.lynx.service.SubjectService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private SubjectDao subjectDao;
    
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Subject getSubjectById(Long subjectId) {
        return subjectDao.findById(subjectId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Subject> getAllSubjects() {
        return subjectDao.findAll();
    }

    @Override
    @Transactional
    public void addSubject(Subject subject) {
        subjectDao.save(subject);
    }

    @Override
    @Transactional
    public void updateSubject(Subject subject) {
        subjectDao.update(subject);
    }

    @Override
    @Transactional
    public void removeSubject(Long subjectId) {
        subjectDao.delete(subjectId);
    }
} 