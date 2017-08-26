package framework.yaomy.example;
/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomingyang
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月26日 下午6:39:17
 */
public class StringDemo {

	public static void main(String[] args) {
		String str = "abcdefg";
		System.out.println(getStrLenght(str));
		System.out.println(getInterceptChar(str, 2));
		System.out.println(str.toCharArray());
		System.out.println(str.startsWith("ab"));
		System.out.println(str.startsWith("c", 1));
		System.out.println(str.endsWith("fg"));
		System.out.println(str.indexOf("b"));
		System.out.println(str.indexOf(3));
		System.out.println(str.isEmpty());
		System.out.println(str.concat("ffffffff"));
		System.out.println(str.compareTo("abcdefG"));
		System.out.println(str.compareToIgnoreCase("abcdefG"));
		System.out.println(str.equals("ds"));
		System.out.println(str.equals("DS"));
	}
	/**
	 * 
	 * @Description:截取字符串到指定的数组之中并且指定开始索引
	 * @param str 要被截取的字符串
	 * @param start 截取字符串开始位置
	 * @param end 截取字符串结束位置
	 * @param target 截取的字符串放入的目标数组
	 * @param targetStart 放入目标数组的开始索引
	 * @author yaomingyang
	 * @date 2017年8月26日 下午7:02:15
	 */
	public static void getChars(String str, int start, int end, char[] target, int targetStart) {
		if(str != null && str.length() != 0) {
			str.getChars(start, end, target, targetStart);
		}
	}
	/**
	 * 
	 * @Description:获取字符串中指定的一个字符
	 * @param  str 字符串
	 * @param n 要获取字符串中第几个字符 从1开始
	 * @author yaomingyang
	 * @date 2017年8月26日 下午6:49:44
	 */
	public static String getInterceptChar(String str, int n) {
		if(str!= null) {
			char c = str.charAt(n-1);
			return String.valueOf(c);
		}
		return null;
	}
	/**
	 * 
	 * @Description:获取字符串的长度
	 * @param 字符串
	 * @author yaomingyang
	 * @date 2017年8月26日 下午6:45:49
	 */
	public static int getStrLenght(String str) {
		if(str != null) {
			return str.length();
		}
		return 0;
	}
}
