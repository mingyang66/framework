package framework.yaomy.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

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
			collection = new DBCollection(db, db.getCollection(collectionName));
			return collection;
		}catch(RuntimeException e){
			GGLogger.error("获取"+collectionName+"的集合异常！"+e);
			return null;
		}
	}
}