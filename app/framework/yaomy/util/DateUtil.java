
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
		return getLatelyMonthDate(date, format, -1);
	}
	/**
	 * 
	 * @Description:获取指定日期向前几个月或者想后几个月
	 * @param month 向前或者向后的约束 可为正或负数
	 * @author yaomy
	 * @date 2017年8月31日 上午11:31:43
	 */
	public static Date getLatelyMonthDate(Date date, String format, int month) {
		if(date == null) {
			return null;
		}
		if(StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + month);
		
		try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			return null;
		}
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
	/**
	 * 数字转日期
	 */
	public static Date integerToDate(Integer date){
		if(date == null) {
			return null;
		}
		return stringToDate(date.toString(), "yyyyMMdd");
	}
	/**
	 * 
	 * @Description:日期转数字
	 * @author yaomy
	 * @date 2017年9月11日 下午4:18:01
	 */
	public static Integer dateToInteger(Date date){
		String result = dateToString(date,"yyyyMMdd");
    	if(result != null && StringUtils.isNotBlank(result)){
    		return Integer.parseInt(result);
    	}
    	return null;
	}
}
