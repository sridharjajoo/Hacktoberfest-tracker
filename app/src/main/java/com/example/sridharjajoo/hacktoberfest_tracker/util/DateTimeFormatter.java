package com.example.sridharjajoo.hacktoberfest_tracker.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateTimeFormatter {
    private final String DATE_FORMAT = "yyyy-MM-ddTHH:mm:ss";
    SimpleDateFormat sdf;
    public DateTimeFormatter()
    {
        this.sdf = new SimpleDateFormat(DATE_FORMAT);
    }
    public String getStringifiedDateTime(Date date) {
         return sdf.format(date);
    }
}
