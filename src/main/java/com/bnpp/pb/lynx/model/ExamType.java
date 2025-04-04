package com.bnpp.pb.lynx.model;

public enum ExamType {
    MONTHLY("Monthly"),
    MID("Mid"),
    ANNUAL("Annual");
    
    private String displayName;
    
    ExamType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
} 