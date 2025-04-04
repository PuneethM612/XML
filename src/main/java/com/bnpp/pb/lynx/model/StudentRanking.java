package com.bnpp.pb.lynx.model;

import java.io.Serializable;

public class StudentRanking implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String rollNumber;
    private String name;
    private Integer totalMarks;
    private ExamType examType;
    private Integer rank;
    
    public StudentRanking() {
    }
    
    public StudentRanking(String rollNumber, String name, Integer totalMarks, ExamType examType, Integer rank) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.totalMarks = totalMarks;
        this.examType = examType;
        this.rank = rank;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getTotalMarks() {
        return totalMarks;
    }
    
    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }
    
    public ExamType getExamType() {
        return examType;
    }
    
    public void setExamType(ExamType examType) {
        this.examType = examType;
    }
    
    public Integer getRank() {
        return rank;
    }
    
    public void setRank(Integer rank) {
        this.rank = rank;
    }
    
    @Override
    public String toString() {
        return "StudentRanking{" +
                "rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", totalMarks=" + totalMarks +
                ", examType=" + examType +
                ", rank=" + rank +
                '}';
    }
} 