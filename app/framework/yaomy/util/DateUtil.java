
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
	public static Date getLastMonthDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(getLastMonthStr(date, format));
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
	public static String getLastMonthStr(Date date, String format) {
		if(date == null) {
			return null;
		}
		if(StringUtils.isBlank(format)) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(getLastMonth(date));
	}
}
