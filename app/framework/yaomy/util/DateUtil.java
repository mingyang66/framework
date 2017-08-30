
package framework.yaomy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:日期工具类
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月29日 下午7:46:01
 */
public class DateUtil {
	/**
	 * 
	 * @Description:当前日期往前推一个月，即获取上一个月的时间
	 * @author yaomy
	 * @date 2017年8月29日 下午7:55:05
	 * 
	 */
	public static Date getLastMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		return cal.getTime();
	}
	/**
	 * 
	 * @Description:返回日期的上一个月日期
	 * @author yaomy
	 * @date 2017年8月29日 下午8:31:39
	 */
	public static Date getLastMonthDate(Date date) {
		return getLastMonthDate(date, null);
	}
	/**
	 * 
	 * @Description:返回日期的上一个月日期
	 * @author yaomy
	 * @date 2017年8月29日 下午8:31:39
	 */
	public static Date getLastMonthDate(Date date, String format) {
		if(StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(getLastMonthToStr(date, format));
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 
	 * @Description:返回上个月字符串类型日期
	 * @author yaomy
	 * @date 2017年8月29日 下午8:31:03
	 */
	public static String getLastMonthToStr(Date date) {
		return getLastMonthToStr(date, null);
	}
	/**
	 * 
	 * @Description:返回上个月字符串类型日期
	 * @author yaomy
	 * @date 2017年8月29日 下午8:31:03
	 */
	public static String getLastMonthToStr(Date date, String format) {
		if(date == null) {
			return null;
		}
		if(StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(getLastMonth(date));
	}
	/**
	 * 
	 * @Description:获取指定日期往前或往后推hour个小时的日期,当前日期之前负数-2，之后正数2
	 * @author yaomy
	 * @date 2017年8月30日 下午2:13:19
	 */
	public static Date getLatelyHourDate(Date date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)+hour);
		
		return cal.getTime();
	}
	/**
	 * 
	 * @Description:格式化日期
	 * @author yaomy
	 * @date 2017年8月30日 下午1:21:50
	 */
	public static Date formatDate(Date date) {
		return formatDate(date, null);
	}
	/**
	 * 
	 * @Description:格式化日期
	 * @author yaomy
	 * @date 2017年8月30日 下午1:21:50
	 */
	public static Date formatDate(Date date, String format) {
		if(date == null) {
			return null;
		}
		if(StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(formatDateToStr(date, format));
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 
	 * @Description:将日期转换成字符串类型
	 * @author yaomy
	 * @date 2017年8月30日 下午1:24:43
	 */
	public static String formatDateToStr(Date date) {
		return formatDateToStr(date, null);
	}
	/**
	 * 
	 * @Description:将日期转换成字符串类型
	 * @author yaomy
	 * @date 2017年8月30日 下午1:24:43
	 */
	public static String formatDateToStr(Date date, String format) {
		if(date == null) {
			return null;
		}
		if(StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	/**
	 * 
	 * @Description:将字符串类型日期转换成指定格式的日期对象
	 * @author yaomy
	 * @date 2017年8月30日 下午1:26:29
	 */
	public static Date formatStrToDate(String date) {
		return formatStrToDate(date, null);
	}
	/**
	 * 
	 * @Description:将字符串类型日期转换成指定格式的日期对象
	 * @author yaomy
	 * @date 2017年8月30日 下午1:26:29
	 */
	public static Date formatStrToDate(String date, String format) {
		if(date == null) {
			return null;
		}
		if(StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)-1);
		
		System.out.println(formatDateToStr(getLatelyHourDate(new Date(), -2), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(getLatelyHourDate(new Date(), 2));
		System.out.println(formatDateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(formatDateToStr(new Date(), "yyyy-MM-dd HH:mm:ss").substring(11, 16));
	}
}
