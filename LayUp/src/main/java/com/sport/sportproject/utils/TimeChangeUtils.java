package com.sport.sportproject.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class TimeChangeUtils {
    /**
     * 将毫秒字符串转成时间格式yyyy-MM-dd HH:mm:ss
     *
     * @param
     * @return
     */
    public static String getTimeFormat(String timeStr) {
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

    /**
     * 将毫秒值转为分钟数  例如播放视频时间 18 ：45
     * @param timeStr
     * @return
     */
    public static String getmilltoTime(String timeStr){
        long time = Long.parseLong(timeStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);

        int minute = calendar.get(Calendar.MINUTE);
        String minuteStr = addZero(minute);
        int second = calendar.get(Calendar.SECOND);
        String secondStr = addZero(second);

        return (minuteStr+" : "+secondStr);
    }

    private static String addZero(int param) {
        String paramStr = param < 10 ? "0" + param : "" + param;
        return paramStr;
    }

    /**
     * 将时间格式yyyy-MM-dd HH:mm:ss转成毫秒
     *
     * @param
     * @return
     * @throws ParseException
     */
    public static Long getTimeFormat2mill(String timeStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(timeStr);
        long ts = date.getTime();
        return ts;
    }

    /**
     * 将时间格式yyyyMMddHHmmss转成毫秒
     *
     * @param
     * @return
     * @throws ParseException
     */
    public static Long getTimeString2mill(String timeStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = simpleDateFormat.parse(timeStr);
        long ts = date.getTime();
        return ts;
    }

    /**
     * 将毫秒转成时间串yyyyMMddHHmmss
     *
     * @param
     * @return
     * @throws ParseException
     */
    public static String getmill2TimeString(String timeStr) throws ParseException {
        return getTimeFormat(timeStr).replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
    }

    /**
     * 将时间格式yyyyMMddHHmmss转成将时间格式yyyy-MM-dd HH:mm:ss
     *
     * @param
     * @return
     * @throws ParseException
     */
    public static String getTimeString2TimeFormat(String timeStr) throws ParseException {
        return getTimeFormat("" + getTimeString2mill(timeStr));
    }

    /**
     * 将时间格式yyyy-MM-dd HH:mm:ss转成将时间格式yyyyMMddHHmmss
     *
     * @param
     * @return
     * @throws ParseException
     */
    public static String getTimeFormat2TimeString(String timeFormat) throws ParseException {
        return getmill2TimeString("" + getTimeFormat2mill(timeFormat));
    }

    /**
     * 计算两个时间的间隔,返回分钟数值，不足一分钟舍去，计算的时间为标准时间格式yyyy-MM-dd HH:mm:ss
     *
     * @param
     * @return
     */
    public static String getIntevalTime(String startTime, String endTime) throws ParseException {
        long intevaltime = getTimeFormat2mill(endTime) - getTimeFormat2mill(startTime);
        return "" + intevaltime / 60000;
    }

    /**
     * 将分钟数值转成时间字符串
     *
     * @param
     * @return
     */
    public static String minute2Hour(String min) {
        int num = Integer.parseInt(min);
        int hour = num / 60;
        int minute = num % 60;
        if (hour == 0) {
            return minute + "分钟";
        }
        return hour + "小时" + minute + "分钟";
    }

    private static long ONE_DAY = 86400000;

    /**
     * 由过去的某一时间,计算距离当前的时间
     */
    public static String CalculateTime(String time) {
        long nowTime = System.currentTimeMillis();  //获取当前时间的毫秒数
        String msg = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//指定时间格式
        Date setTime = null;  //指定时间
        try {
            setTime = sdf.parse(time);  //将字符串转换为指定的时间格式
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long reset = setTime.getTime();   //获取指定时间的毫秒数
        long dateDiff = nowTime - reset;

        if (dateDiff < 0) {
            msg = "输入的时间不对";
        } else {

            long dateTemp1 = dateDiff / 1000; //秒
            long dateTemp2 = dateTemp1 / 60; //分钟
            long dateTemp3 = dateTemp2 / 60; //小时
            long dateTemp4 = dateTemp3 / 24; //天数
            long dateTemp5 = dateTemp4 / 30; //月数
            long dateTemp6 = dateTemp5 / 12; //年数

            if (dateTemp6 > 0) {
                msg = dateTemp6 + "年前";

            } else if (dateTemp5 > 0) {
                msg = dateTemp5 + "个月前";

            } else if (dateTemp4 > 0) {
                msg = dateTemp4 + "天前";

            } else if (dateTemp3 > 0) {
                msg = dateTemp3 + "小时前";

            } else if (dateTemp2 > 0) {
                msg = dateTemp2 + "分钟前";

            } else if (dateTemp1 > 0) {
                msg = "刚刚";

            }
        }
        return msg;


    }



    public static String getWeek(String pTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = getTime();
        Date date = new Date(time);
        Date date1 = new Date(time - ONE_DAY);
        String today = format.format(date);
        String yesterday = format.format(date1);
        if (today.equals(pTime)) {
            return "今天";
        }
        if (yesterday.equals(pTime)) {
            return "昨天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            return "周日";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            return "周一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            return "周二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            return "周三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            return "周四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            return "周五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            return "周六";
        }
        return "";
    }

    /**
     * 获取当前的时间戳
     *
     * @return
     */
    private static long getTime() {
        //获取当前的毫秒值
        long time = System.currentTimeMillis();
        //返回出去
        return time;
    }

}