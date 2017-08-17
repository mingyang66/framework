package mongo;

import org.bson.Document;

import utils.GGConfigurer;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * 
 * @author yaomy
 *
 */
public class GGMongoCollection {

	public static MongoDatabase getDB(String dbName){
		MongoClient client = GGMongoClientPool.pool.getMongoClient(dbName);
		return client.getDatabase(GGConfigurer.get("ggmongodb."+dbName+".name"));
	}
	/**
	 * 
	 * @Description:TODO
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
}