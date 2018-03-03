package com.geek.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateTimeConverter implements Converter<String,LocalDateTime> {

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public LocalDateTime convert(String source) {
        if (source != null || !"".equals(source)){
            return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(PATTERN));
        }
        return LocalDateTime.now();
    }
}
