package com.bnpp.pb.lynx.config;

import com.bnpp.pb.lynx.model.ExamType;
import org.springframework.core.convert.converter.Converter;

public class StringToExamTypeConverter implements Converter<String, ExamType> {
    
    @Override
    public ExamType convert(String source) {
        try {
            return ExamType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
} 