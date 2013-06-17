package cn.ibm.com.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 说明 ：日期 作者： gaoyunz 创建日期：2010-11-27 最后修改日期：2010-11-27 修改记录：
 */
public class DateUtils {
	/*
	 * method 将字符串类型的日期转换为一个Date
	 * 
	 * @param dateString 需要转换为Date的字符串
	 * 
	 * @return dataTime Date
	 */
	public final static Date string2Date(String dateString) {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
		dateFormat.setLenient(false);
		java.util.Date timeDate = null;
		try {
			timeDate = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}// util类型
		return timeDate;
	}

	/**
	 * 将字符串类型的日期转换为一个Date
	 * 
	 * @param dateString
	 * @param pattern
	 *            格式化字符串
	 * @return
	 */
	public final static Date string2Date(String dateString, String pattern) {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(pattern, Locale.CHINESE);
		dateFormat.setLenient(false);
		java.util.Date timeDate = null;
		try {
			timeDate = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}// util类型
		return timeDate;
	}

	/**
	 * 将Date日期转换为一个字符串类型
	 * 
	 * @param dateString
	 * @param pattern
	 *            格式化字符串
	 * @return
	 */
	public final static String Date2String(Date date, String pattern) {
		if (date != null) {
			DateFormat dateFormat;
			dateFormat = new SimpleDateFormat(pattern, Locale.CHINESE);
			dateFormat.setLenient(false);
			String timeStr = null;
			timeStr = dateFormat.format(date);
			return timeStr;
		} else {
			return null;
		}
	}

	/**
	 * 获取N年前的1月1日的日期
	 * 
	 * @param date
	 *            当前日期
	 * @param prevYear
	 *            多少年前
	 * @return
	 */
	public final static Date getPrevYearFirstDate(Date date, int prevYear) {
		Calendar calendar = Calendar.getInstance(Locale.CHINESE);
		calendar.setTime(date);
		int year = calendar.get(calendar.YEAR);
		year = year - prevYear;
		try {
			calendar.set(year, 0, 1);
		} catch (Exception e) {
		}

		return calendar.getTime();
	}

	/**
	 * 获取N年后的1月1日的日期
	 * 
	 * @param date
	 *            当前日期
	 * @param prevYear
	 *            多少年前
	 * @return
	 */
	public final static Date getAfterYearFirstDate(Date date, int afterYear) {
		Calendar calendar = Calendar.getInstance(Locale.CHINESE);
		calendar.setTime(date);
		int year = calendar.get(calendar.YEAR);
		year = year + afterYear;
		try {
			calendar.set(year, 0, 1);
		} catch (Exception e) {
		}

		return calendar.getTime();
	}

	/**
	 * 获取N天前的日期
	 * 
	 * @param date
	 *            当前日期
	 * @param prevDay
	 *            多少天前
	 * @return
	 */
	public final static Date getPrevDay(Date date, int prevDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, (prevDay*-1));
		return cal.getTime();
	}

	public static final Date convertStringToDate(String pattern, Locale locale,
			TimeZone zone, String strDate) throws ParseException {

		if (locale == null)
			locale = Locale.getDefault();
		if (zone == null)
			zone = TimeZone.getDefault();
		SimpleDateFormat df = new SimpleDateFormat(pattern, locale);
		df.setTimeZone(zone);
		try {
			return df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}
	}

	/**
	 * 提供yyyy-MM-dd类型的日期字符串转化
	 */
	public static final Date getBeginDate(String beginDate) {

		Locale locale = Locale.CHINESE;
		try {
			return convertStringToDate("yyyy-MM-dd HH:mm:ss", locale, null,
					beginDate + " 00:00:00");
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 提供yyyy-MM-dd类型的日期字符串转化 专门提供Web页面结束日期转化 如输入2006-07-27，则转化为2006-07-28
	 * 00:00:00
	 */
	public static final Date getEndDate(String endDate) {

		Locale locale = Locale.CHINESE;
		try {
			Date date = convertStringToDate("yyyy-MM-dd HH:mm:ss", locale,
					null, endDate + " 00:00:00");
			// return new Date(date.getTime() + 24 * 3600 * 1000);
			return date;
		} catch (Exception e) {
			return null;
		}
	}
	

}
