package com.example.dma_course_spring.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static String formatDate(Date date) {
        return date != null ? dateFormat.format(date) : null;
    }
}
