
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
	 * @Description:返回日期的上一个月日期
	 * @author yaomy
	 * @date 2017年8月29日 下午8:31:39
	 */
	public static Date getBeforeOneMonthToDate(Date date) {
		return getBeforeOneMonthToDate(date, null);
	}
	/**
	 * 
	 * @Description:返回日期的上一个月日期
	 * @author yaomy
	 * @date 2017年8月29日 下午8:31:39
	 */
	public static Date getBeforeOneMonthToDate(Date date, String format) {
		if(StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(getBeforeOneMonthToString(date, format));
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
	public static String getBeforeOneMonthToString(Date date) {
		return getBeforeOneMonthToString(date, null);
	}
	/**
	 * 
	 * @Description:返回上个月字符串类型日期
	 * @author yaomy
	 * @date 2017年8月29日 下午8:31:03
	 */
	public static String getBeforeOneMonthToString(Date date, String format) {
		if(date == null) {
			return null;
		}
		if(StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
		return sdf.format(cal.getTime());
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
			return sdf.parse(dateToString(date, format));
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
	public static String dateToString(Date date) {
		return dateToString(date, null);
	}
	/**
	 * 
	 * @Description:将日期转换成字符串类型
	 * @author yaomy
	 * @date 2017年8月30日 下午1:24:43
	 */
	public static String dateToString(Date date, String format) {
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
	public static Date stringToDate(String date) {
		return stringToDate(date, null);
	}
	/**
	 * 
	 * @Description:将字符串类型日期转换成指定格式的日期对象
	 * @author yaomy
	 * @date 2017年8月30日 下午1:26:29
	 */
	public static Date stringToDate(String date, String format) {
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
	/**
	 * 
	 * @Description:获取当前日期
	 * @author yaomy
	 * @date 2017年8月31日 上午9:23:53
	 */
	public static Date getNowDate(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTime();
	}
	/**
	 * 
	 * @Description:获取当前日期所在月的第一天
	 * @author yaomy
	 * @date 2017年8月31日 上午9:50:17
	 */
	public static Date getfirstDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTime();
	}
	/**
	 * 
	 * @Description:获取指定日期所在月的第一天
	 * @author yaomy
	 * @date 2017年8月31日 上午9:46:38
	 */
	public static Date getfirstDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTime();
	}
	/**
	 * 
	 * @Description:获取当前日期所在月的最后一天
	 * @author yaomy
	 * @date 2017年8月31日 上午9:49:48
	 */
	public static Date getLastDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTime();
	}
	/**
	 * 
	 * @Description:获取指定日期所在月的最后一天
	 * @author yaomy
	 * @date 2017年8月31日 上午9:45:04
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTime();
	}
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)-1);
		
		System.out.println(dateToString(getLatelyHourDate(new Date(), -2), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(getLatelyHourDate(new Date(), 2));
		System.out.println(dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(dateToString(new Date(), "yyyy-MM-dd HH:mm:ss").substring(11, 16));
		System.out.println(getNowDate());
		System.out.println(dateToString(getNowDate(), "yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println(getLastDayOfMonth(getNowDate()));
		System.out.println(getfirstDayOfMonth(getNowDate()));
	}
}
