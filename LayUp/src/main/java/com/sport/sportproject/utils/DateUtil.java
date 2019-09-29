package com.sport.sportproject.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 *   梨花带雨,我见优伶  
 *      2019/4/10        
 */
public class DateUtil {
    // YYYY-MM-DD h:m:s
    public static String getTimeFormat_Yyyy_Mm_Dd_h_m_s(String timeStr) {
        long time = Long.parseLong(timeStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String monthStr = addZero(month);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String dayStr = addZero(day);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);//24小时制
        String hourStr = addZero(hour);
        int minute = calendar.get(Calendar.MINUTE);
        String minuteStr = addZero(minute);
        int second = calendar.get(Calendar.SECOND);
        String secondStr = addZero(second);
        return (year + "-" + monthStr + "-" + dayStr + " "
                + hourStr + ":" + minuteStr + ":" + secondStr);
    }

    private static String addZero(int param) {
        String paramStr = param < 10 ? "0" + param : "" + param;
        return paramStr;
    }

    // 分:秒  m:s
    public static String getTimeFormatm_m_s(String timeStr) {
        long time = Long.parseLong(timeStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int minute = calendar.get(Calendar.MINUTE);
        String minuteStr = addZero(minute);
        int second = calendar.get(Calendar.SECOND);
        String secondStr = addZero(second);
        return (minuteStr + ":" + secondStr);
    }

    public static String getTime_Yyyy_Mm_Dd(String timeStr) {
        long time = Long.parseLong(timeStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String monthStr = addZero(month);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String dayStr = addZero(day);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);//24小时制
        String hourStr = addZero(hour);
        int minute = calendar.get(Calendar.MINUTE);
        String minuteStr = addZero(minute);
        int second = calendar.get(Calendar.SECOND);
        String secondStr = addZero(second);
        return (year + "-" + monthStr + "-" + dayStr + " "
                + hourStr + ":" + minuteStr + ":" + secondStr);
    }

    public static String getTime_YyyyMmdd(String tiems) {
        Date date = new Date(Long.parseLong(tiems + "000"));
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String timsStr = simpleDateFormat.format(date);
        return timsStr;
    }

    public static String getTimeYMD(String tiems) {
        Date date = new Date(Long.parseLong(tiems + "000"));
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String timsStr = simpleDateFormat.format(date);
        return timsStr;
    }

    public static String getTimeymdhm(String tiems) {
        Date date = new Date(Long.parseLong(tiems + "000"));
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String timsStr = simpleDateFormat.format(date);
        return timsStr;
    }

    public static String getTimeYM(String tiems) {
        Date date = new Date(Long.parseLong(tiems + "000"));
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String timsStr = simpleDateFormat.format(date);
        return timsStr;
    }


}
