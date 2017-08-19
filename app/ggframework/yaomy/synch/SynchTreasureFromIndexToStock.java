
package ggframework.yaomy.synch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

import ggframework.yaomy.config.GGConfigurer;
import ggframework.yaomy.mongo.DBCollection;
import ggframework.yaomy.mongo.DBCursor;
import ggframework.yaomy.mongo.GGMongoClientPool;
import ggframework.yaomy.mongo.GGMongoClients;
import utils.MongoUtil;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月18日 上午10:38:09
 */
public class SynchTreasureFromIndexToStock {

	public static void main(String[] args) {
		GGConfigurer.load("conf/application.conf");
		GGMongoClientPool.pool.initPool(GGMongoClients.getClients());
		
//		DBCollection collectionY = MongoUtil.getGGIndexCollection("personal_radar_stock_list");
		DBCollection collection = MongoUtil.getGGUserCollection("t_app_seek_treasure_01");
		
		Document query = new Document();
		query.append("seek_mark", new Document("$ne", null));
		
		Document fields = new Document();
		fields.append("stock_code", 1);
		fields.append("sname", 1);
		fields.append("radar_count", 1);
		fields.append("list_id", 1);
		DBCursor cursor = collection.find(query, fields).limit(10);
		while(cursor.hasNext()){
			Document doc = cursor.next();
			System.out.println(doc.toJson());
		}
		cursor.close();
		
//		query = new Document();
//		query.append("list_id", new Document("$in", listIds));
//		
//		DBCursor cursorY = collectionY.find(query);
//		Map<Long, String> map = new HashMap<Long, String>();
//		while(cursorY.hasNext()){
//			Document docY = cursorY.next();
//			map.put(docY.getLong("list_id"), docY.getString("radar_code"));
//			System.out.println("=======");
//			System.out.println(docY);
//		}
//		cursorY.close();
//		System.out.println(map.size()+"=====================////////////////////////");
	}
}
