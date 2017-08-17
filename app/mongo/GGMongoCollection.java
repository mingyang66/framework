package mongo;

import org.bson.Document;

import utils.GGConfigurer;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
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
public class GGMongoCollection {

	/**
	 * 
	 * @Description:获取指定数据库的数据库对象
	 * @author yaomy
	 * @date 2017年8月17日 下午8:01:49
	 */
	public static MongoDatabase getDB(String dbName){
		MongoClient client = GGMongoClientPool.pool.getMongoClient(dbName);
		return client.getDatabase(GGConfigurer.get("ggmongodb."+dbName+".name"));
	}
	/**
	 * 
	 * @Description:获取指定数据库中指定集合对象
	 * @author yaomy
	 * @date 2017年8月17日 下午5:38:36
	 */
	public static MongoCollection<Document> getDBCollection(String dbName, String collection){
		try{
			return getDB(dbName).getCollection(collection);
		}catch(RuntimeException e){
			return null;
		}
	}
	/**
	 * 
	 * @Description:获取指定数据库的所有集合名称
	 * @author yaomy
	 * @date 2017年8月17日 下午8:00:52
	 */
	public static MongoIterable<String> listCollectionNames(String dbName){
		return getDB(dbName).listCollectionNames();
	}
	/**
	 * 
	 * @Description:获取数据库中的所有集合对象对应的所有基本信息
	 * @author yaomy
	 * @date 2017年8月17日 下午8:04:29
	 */
	public static ListCollectionsIterable<Document> listCollections(String dbName){
		return getDB(dbName).listCollections();
	}
	/**
	 * 
	 * @Description:TODO
	 * @author yaomy
	 * @date 2017年8月17日 下午8:13:40
	 */
	public static <T> ListCollectionsIterable<T> listCollections(String dbName, Class<T> resultClass){
		return getDB(dbName).listCollections(resultClass);
	}
}