
package ggframework.yaomy.synch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

import ggframework.yaomy.mongo.DBCollection;
import ggframework.yaomy.mongo.GGMongoClientPool;
import ggframework.yaomy.mongo.GGMongoClients;
import utils.GGConfigurer;
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
		
		DBCollection collectionY = MongoUtil.getGGIndexCollection("personal_radar_stock_list");
		DBCollection collection = MongoUtil.getGGStockCollection("t_app_seek_treasure_01");
		
		Document query = new Document();
		query.append("seek_mark", new Document("$ne", null));
		
		FindIterable<Document> docs = collection.find(query).limit(108);
		MongoCursor<Document> cursor = docs.iterator();
		Set<Long> listIds = new HashSet<Long>();
		while(cursor.hasNext()){
			Document doc = cursor.next();
			System.out.println(doc.getInteger("list_id"));
			listIds.add(doc.getInteger("list_id").longValue());
		}
		cursor.close();
		System.out.println(listIds.size());
		
		query = new Document();
		query.append("list_id", new Document("$in", listIds));
		
		FindIterable<Document> docsY = collectionY.find(query);
		MongoCursor<Document> cursorY = docsY.iterator();
		Map<Long, String> map = new HashMap<Long, String>();
		while(cursorY.hasNext()){
			Document docY = cursorY.next();
			map.put(docY.getLong("list_id"), docY.getString("radar_code"));
			System.out.println("=======");
			System.out.println(docY);
		}
		cursorY.close();
		System.out.println(map.size()+"=====================////////////////////////");
	}
}
