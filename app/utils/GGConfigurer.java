package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
/**
 * RuntimeException 异常是java 虚拟机正常操作期间可以抛出异常的父类
 * 
 *
 */
public class GGConfigurer {

	private static Properties prop = new Properties();

	public static void load(String fileName){
		try {
			prop.load(new FileInputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			System.out.println("配置文件找不到"+e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static String getKey(String key){
		try{
			return prop.getProperty(key);
		}catch(RuntimeException e){
			return null;
		}
	}
	public static String getKey(String key, String defaultValue){
		return (getKey(key) == null) ? defaultValue : getKey(key);
	}
	
	public static String get(String key){
		try{
			return prop.getProperty(key);
		}catch(RuntimeException e){
			return null;
		}
	}
	public static String get(String key, String defaultValue){
		return (getKey(key) == null) ? defaultValue : getKey(key);
	}
	
	public static Integer getInteger(String key){
		try{
			return (getKey(key) == null) ? null : Integer.parseInt(getKey(key));
		}catch(RuntimeException e){
			return null;
		}
	}
	public static int getInteger(String key, int defaultValue){
		return (getInteger(key) == null) ? defaultValue : getInteger(key).intValue();
	}
	
	public static Long getLong(String key){
		try{
			return (getKey(key)) == null ? null : Long.valueOf(getKey(key));
		}catch(RuntimeException e){
			return null;
		}
	}
	public static long getLong(String key, long defaultValue) {
		return (getLong(key) == null) ? defaultValue : getLong(key).longValue();
	}
	
	public static Double getDouble(String key){
		try{
			return (getKey(key) == null) ? null : Double.valueOf(getKey(key));
		}catch(RuntimeException e){
			return null;
		}
	}
	public static double getDouble(String key, double defaultValue) {
		return (getDouble(key) == null) ? defaultValue : getDouble(key).doubleValue();
	}
	
	public static Float getFloat(String key){
		try{
			return (getKey(key) == null) ? null : Float.valueOf(getKey(key));
		}catch(RuntimeException e){
			return null;
		}
	}
	public static float getFloat(String key, float defaultValue) {
		return (getFloat(key) == null) ? defaultValue : getFloat(key).floatValue();
	}
	
	public static Boolean getBoolean(String key){
		try{
			return (getKey(key) == null) ? null : Boolean.valueOf(getKey(key));
		}catch(RuntimeException e){
			return null;
		}
	}
	public static boolean getBoolean(String key, boolean defaultValue){
		return (getBoolean(key) == null) ? defaultValue : getBoolean(key).booleanValue();
	}
	
	public static boolean containsKey(String key){
		return prop.containsKey(key);
	}
	
	public static Set<Object> keySet(){
		return prop.keySet();
	}
}
