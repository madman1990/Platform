package com.imobpay.commons.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.imobpay.commons.log.LogPay;

/**
 * 日期时间处理工具类 ClassName: DateUtil <br/>
 * date: 2016年6月1日 下午4:26:02 <br/>
 * 
 * @author Lance.WU
 * @since JDK 1.6 platform 1.0
 */
public final class DateUtils {

    /** 日期时间格式 */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    /** 日期时间格式 */
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    /** 日期 格式 年月 */
    public static final String YYYYMM = "yyyyMM";
    /** 日期 格式 */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    /** 日期 格式 */
    public static final String YYYYMMDD = "yyyyMMdd";

    /** 时间格式 */
    public static final String HHMMSS = "HHmmss";

    /** 年月日时分秒毫秒 */
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：yyyyMMdd.<br/>
     * 
     * @author Lance.Wu <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrDate() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：自定义格式.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param format
     *            自定义格式 <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrDate(String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：自定义格式.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param l
     *            时间格式 <br/>
     * @param format
     *            自定义格式 <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrDate(long l, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(new Date(l));
    }

    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：自定义格式.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param date
     *            时间 <br/>
     * @param format
     *            自定义格式 <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrDate(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：yyyyMMdd.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param dateStr
     *            时间字符串 <br/>
     * @return 返回结果：Date <br/>
     * @throws ParseException
     *             转换异常 <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static Date getCurrDateStr(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.parse(dateStr);
    }

    /**
     * getCurrTime:(获取当前日期). <br/>
     * 格式为：hhMMss.<br/>
     * 
     * @author Lance.Wu <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrTime() {
        DateFormat df = new SimpleDateFormat("HHmmss");
        return df.format(new Date());
    }

    /**
     * getCurrTime:(获取当前日期). <br/>
     * 格式为：hhMMss.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param format
     *            格式化 <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrTime(String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    /**
     * addDate:(计算时间格式). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param date
     *            时间 <br/>
     * @param num
     *            基数 <br/>
     * @param calendarType
     *            时间格式【Calendar:DATE 天数, DAY_OF_MONTH, YEAR,】 <br/>
     * @return 返回结果：int 返回天数 <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static Date addDate(Date date, int num, int calendarType) {
        Calendar sc = Calendar.getInstance();
        sc.setTime(date);
        sc.add(calendarType, num);
        return sc.getTime();
    }

    /**
     * addDate:(计算时间格式). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param date
     *            时间 <br/>
     * @param num
     *            基数 <br/>
     * @param calendarType
     *            时间格式【Calendar:DATE 天数, DAY_OF_MONTH, YEAR,】 <br/>
     * @return 返回结果：int 返回天数 <br/>
     * @throws ParseException
     *             转换失败
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static Date addDate(String date, int num, int calendarType) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        Calendar sc = Calendar.getInstance();
        sc.setTime(sd.parse(date));
        sc.add(calendarType, num);
        return sc.getTime();
    }

    /**
     * addDate:(计算时间格式). <br/>
     * 
     * @author Lance.Wu <br/>
     *         修改者: Jason.H 修改时间 : 2016年11月15日11:12:12
     * @param date
     *            时间 <br/>
     * @param num
     *            基数 <br/>
     * @param calendarType
     *            时间格式【Calendar:DATE 天数, DAY_OF_MONTH, YEAR,】 <br/>
     * @param formart
     *            返回内容格式 <br/>
     * @return 返回结果：int 返回天数 <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String addDate(Date date, int num, int calendarType, String formart) {
        Calendar sc = Calendar.getInstance();
        sc.setTime(date);
        sc.add(calendarType, num);
        SimpleDateFormat sd = new SimpleDateFormat(formart);
        return sd.format(sc.getTime());
    }

    /**
     * 将当前 时间加两个小时返回
     * 
     *
     * 传入字符串类型的数据
     * 
     * @return String
     */

    @SuppressWarnings("static-access")
    public static String timeadd() {
        Date date = null;
        String time = null;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.HOUR_OF_DAY, 2);
        date = calendar.getTime();
        time = format.format(date);

        return time;
    }

    /**
     * 将当前 时间加2分钟返回
     * 
     *
     * 
     * 
     * @return String
     */

    @SuppressWarnings("static-access")
    public static String timeMinueAdd() {
        Date date = null;
        String time = null;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.MINUTE, 2);
        date = calendar.getTime();
        time = format.format(date);

        return time;
    }

    /**
     * 
     * 作用 ： 对Calendar对象进行format参数格式化<br/>
     * 
     * @param date
     *            Calendar参数
     * @param format
     *            String类型格式化字符串
     * @return - 被format格式后的时间字符串
     */
    public static String getFormatDateTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date).toString();
    }

    /**
     * 将原格式 的日期字符串，转换成新的格式
     * 
     * @Title: formatDateByFormat
     * @Description: 将原格式 的日期字符串，转换成新的格式
     * @Date May 3, 2014 21:23:41 PM
     * @modifyDate May 3, 2014 21:23:41 PM
     * @param date
     *            日期对象 java.util.Date
     * @param srcFormat
     *            原格式 java.lang.String
     * @param disFormat
     *            目标格式 java.lang.String
     * @return String 转换后的String日期
     * 
     *         <pre>
     * 案例：
     *    String result = formatDate("20150404",  "yyyyMMdd", "yyyy-MM-dd");
     * 结果：result =  2015-04-04
     * </pre>
     * @since PlatForm 1.0
     */
    public static String formatDate(String date, String srcFormat, String disFormat) {
        SimpleDateFormat srcSdf = null;
        if (StringUtils.isBlank(date)) {
            return "";
        }
        try {
            srcSdf = new SimpleDateFormat(srcFormat);
            // 将原日期转换成毫秒
            long srcDateTimes = srcSdf.parse(date).getTime();
            Date d = new Date();
            d.setTime(srcDateTimes);
            SimpleDateFormat sdf = new SimpleDateFormat(disFormat);
            return sdf.format(d).toString();
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            return null;
        } finally {
            srcSdf = null;
        }
    }

    /**
     * 
     * @param dateStr
     *            日期字符串
     * @param type
     *            类型
     * @param addTime
     *            增加时间
     * @param format
     *            模式
     * @return String
     */
    public static String addDate(String dateStr, int type, int addTime, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(type, addTime);
            Date nowDate = calendar.getTime();
            return dateFormat.format(nowDate);
        } catch (ParseException e) {
            LogPay.error(e.getMessage(), e);
            return null;
        }
    }

}
