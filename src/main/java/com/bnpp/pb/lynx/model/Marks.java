package com.bnpp.pb.lynx.model;

import java.io.Serializable;

public class Marks implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long markId;
    private String rollNumber;
    private ExamType examType;
    private Long subjectId;
    private Integer marks;
    
    public Marks() {
    }
    
    public Marks(Long markId, String rollNumber, ExamType examType, Long subjectId, Integer marks) {
        this.markId = markId;
        this.rollNumber = rollNumber;
        this.examType = examType;
        this.subjectId = subjectId;
        this.marks = marks;
    }
    
    public Long getMarkId() {
        return markId;
    }
    
    public void setMarkId(Long markId) {
        this.markId = markId;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public ExamType getExamType() {
        return examType;
    }
    
    public void setExamType(ExamType examType) {
        this.examType = examType;
    }
    
    public Long getSubjectId() {
        return subjectId;
    }
    
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
    
    public Integer getMarks() {
        return marks;
    }
    
    public void setMarks(Integer marks) {
        this.marks = marks;
    }
    
    @Override
    public String toString() {
        return "Marks{" +
                "markId=" + markId +
                ", rollNumber='" + rollNumber + '\'' +
                ", examType=" + examType +
                ", subjectId=" + subjectId +
                ", marks=" + marks +
                '}';
    }
} 