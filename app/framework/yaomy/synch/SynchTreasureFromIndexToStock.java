
package framework.yaomy.synch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import framework.yaomy.config.GGConfigurer;
import framework.yaomy.log.GGLogger;
import framework.yaomy.mongo.DBCollection;
import framework.yaomy.mongo.DBCursor;
import framework.yaomy.mongo.GGMongoClientPool;
import framework.yaomy.mongo.GGMongoClients;
import framework.yaomy.mongo.GGMongoOperator;
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
		
		DBCollection collection = GGMongoOperator.getGGBusinessDBCollection("t_app_seek_treasure_01");
		
		DBCursor cursor = collection.find();
		GGLogger.info(cursor.tryNext());
		GGLogger.info(cursor.tryNext());
		GGLogger.info(cursor.tryNext());
		while(cursor.hasNext()){
			Document doc = cursor.next();
//			GGLogger.info(dsoc.toJson());
		}
		cursor.close();
		
//		Document setValue = GGMongoOperator.newId(collection);
//		setValue.append("seek_mark", "12");
//		setValue.append("stock_code", "600001");
//		setValue.append("sname", "12");
//		setValue.append("list_id", "12");
//		setValue.append("stock_name", "光大股份");
//		
//		Document setValue1 = new Document();
//		setValue1.append("seek_mark", "1222");
//		setValue1.append("stock_code", "600001");
//		setValue1.append("sname", "12");
//		setValue1.append("list_id", "12");
//		setValue1.append("stock_name", "光大股份");
//		Document setValue2 = new Document();
//		
//		setValue2.append("seek_mark", "12");
//		setValue2.append("stock_code", "600001");
//		setValue2.append("sname", "12");
//		setValue2.append("list_id", "12");
//		setValue2.append("stock_name", "光大股份");
//		setValue2.append("create_date", new Date());
//		
//		collection.insertOne(setValue);
//		
//		List<Document> list = new ArrayList<Document>();
//		list.add(setValue1);
//		list.add(setValue2);
		
//		collection.insertMany(list, true);
		

	}
}
