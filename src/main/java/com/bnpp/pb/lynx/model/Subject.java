package com.bnpp.pb.lynx.model;

import java.io.Serializable;

public class Subject implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long subjectId;
    private String subjectName;
    
    public Subject() {
    }
    
    public Subject(Long subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
    
    public Long getSubjectId() {
        return subjectId;
    }
    
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
    
    public String getSubjectName() {
        return subjectName;
    }
    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    
    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
} 