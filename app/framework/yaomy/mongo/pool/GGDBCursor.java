
package framework.yaomy.mongo.pool;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import framework.yaomy.util.DateUtil;

/**
 * @Description:转换类
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月8日 下午5:53:56
 */
public class GGDBCursor {

	/**
	 * 
	 * @Description:将返回的游标对象转换成List
	 * @author yaomy
	 * @date 2017年9月8日 下午5:56:27
	 */
	public static List<Map<String, Object>> getListMap(DBCursor cursor) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		while(cursor.hasNext()) {
			Document doc = cursor.next();
			Map<String, Object> map = new HashMap<String, Object>();
			for(Iterator<String> it=doc.keySet().iterator();it.hasNext();){
				String key = it.next();
				Object value = doc.get(key);
				if(value instanceof Date) {
					map.put(key, DateUtil.dateToString((Date)value,"yyyy-MM-dd HH:mm:ss"));
				} else {
					map.put(key, value);
				}
			}
			list.add(map);
		}
		cursor.close();
		return list;
	}
}
