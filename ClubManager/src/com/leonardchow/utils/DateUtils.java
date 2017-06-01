package com.leonardchow.utils;

import com.sun.media.sound.InvalidFormatException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.time.*;

public class DateUtils {
    private Calendar calendar;
    /**
     *
     * @param dateString Should be formatted in YYYY-MM-DD or YYYY/MM/DD, all 1-based values
     * @return
     */
    public static DateUtils useDate(String dateString) {
        String formattedStr = dateString.replace('/', '-');
//        Pattern dateP = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
//        if (! Pattern.compile("\\d{4}-\\d{2}-\\d{2}").matcher(formattedStr).matches()) {
//            return null;
//        }
//
//        List<Integer> dateList = Arrays.asList(formattedStr.split("-")).stream().map(Integer::parseInt).collect(Collectors.toList());
//
        DateUtils du = new DateUtils();
//        du.calendar.set(dateList.get(0), dateList.get(1) - 1, dateList.get(2));
//
//        return du;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date fromDate = null;
        try {
            fromDate = df.parse(formattedStr);
        } catch (Exception e) {
            System.err.println("DATEUTIL Error: " + e.getMessage());
        }

        du.calendar.setTime(fromDate);
        return du;
    }

    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public Date toDate() {
        return calendar.getTime();
    }

    public Calendar toCalendar() {
        return calendar;
    }

    public LocalDate toLocalDate() {
        return calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public DateUtils() {
        calendar = Calendar.getInstance();
    }
}
