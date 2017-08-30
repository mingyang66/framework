package framework.yaomy.mongo.pool;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import framework.yaomy.config.GGConfigurer;
import framework.yaomy.log.GGLogger;
/**
 * 
 * @Description:对数据库驱动封装类
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月17日 下午8:02:11
 */
public class GGMongoOperator {

	/**
	 * 
	 * @Description:获取指定数据库的数据库对象
	 * @author yaomy
	 * @date 2017年8月17日 下午8:01:49
	 */
	public static MongoDatabase getDB(String dbName){
		MongoClient client = GGMongoClientPool.pool.getMongoClient(dbName);
		if(GGConfigurer.get("ggmongodb."+dbName+".name") != null){
			return client.getDatabase(GGConfigurer.get("ggmongodb."+dbName+".name"));
		}
		return null;
	}
	/**
	 * 
	 * @Description:获取指定数据库中指定集合对象
	 * @param dbName 数据库名
	 * @param collectionName 集合名称
	 * @author yaomy
	 * @date 2017年8月17日 下午5:38:36
	 */
	public static DBCollection getDBCollection(String dbName, String collectionName){
		MongoDatabase db = getDB(dbName);
		if(db == null){
			return null;
		}
		DBCollection collection = null;
		try{
			collection = new DBCollection(db, db.getCollection(collectionName), collectionName);
			return collection;
		}catch(RuntimeException e){
			GGLogger.error("获取"+collectionName+"的集合异常！"+e);
			return null;
		}
	}
	/**
	 * 
	 * @Description:获取默认数据库集合对象 默认库是business
	 * @param collectionName 集合名称
	 * @author yaomingyang
	 * @date 2017年8月19日 下午6:40:05
	 */
	public static DBCollection getGGBusinessDBCollection(String collectionName) {
		return getDBCollection("business", collectionName);
	}
	/**
	 * 
	 * @Description:获取要新增的文档的主键值 默认库是business
	 * @param collection 集合对象
	 * @author yaomingyang
	 * @date 2017年8月19日 下午5:56:18
	 */
	public static Document newId(DBCollection collection){
		
		return newId(collection, "business");
	}
	/**
	 * 
	 * @Description:获取要新增的文档的主键值
	 * @param collection 集合对象
	 * @author yaomingyang
	 * @date 2017年8月19日 下午5:56:18
	 */
	public static Document newId(DBCollection collection, String dbName){
		DBCollection newCollection = getDBCollection(dbName, "gg_ids");
		
		Document query = new Document("collection_name", collection.getCollectionName());
		DBCursor cursor = newCollection.find(query);
		
		Document result = new Document();
		if(cursor.hasNext()) {
			Document update = new Document();
			update.append("$inc", new Document("id", 1L));
			Document doc = newCollection.findOneAndUpdate(query, update);
			result.append("_id", Long.valueOf(doc.getLong("id")+1L));
		} else {
			Document doc = new Document();
			doc.append("collection_name", collection.getCollectionName());
			doc.append("id", 1L);
			newCollection.insertOne(doc);
			result.append("_id", 1L);
		}
		cursor.close();
		return result;
	}
	/**
	 * 
	 * @Description:新建数据库对应的主键ID
	 * @param collecitonName 要新建ID的表
	 * @author yaomy
	 * @date 2017年8月21日 上午10:39:06
	 */
	public static Document newId(String collecitonName){
		return newId(collecitonName, "business");
	}
	/**
	 * 
	 * @Description:新建数据库对应的主键ID
	 * @param collecitonName 要新建ID的表
	 * @param 数据库名称
	 * @author yaomy
	 * @date 2017年8月21日 上午10:37:27
	 */
	public static Document newId(String collecitonName, String dbName){
		DBCollection newCollection = getDBCollection(dbName, "gg_ids");
		Document query = new Document("collection_name", collecitonName);
		DBCursor cursor = newCollection.find(query);
		
		Document result = new Document();
		if(cursor.hasNext()) {
			Document update = new Document();
			update.append("$inc", new Document("id", 1L));
			Document doc = newCollection.findOneAndUpdate(query, update);
			result.append("_id", Long.valueOf(doc.getLong("id")+1L));
		} else {
			Document doc = new Document();
			doc.append("collection_name", collecitonName);
			doc.append("id", 1L);
			newCollection.insertOne(doc);
			result.append("_id", 1L);
		}
		cursor.close();
		return result;
	}
}