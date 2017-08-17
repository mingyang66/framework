package mongo;

import org.bson.Document;

import utils.GGConfigurer;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class GGMongoOperator {

	public static MongoDatabase getDB(String dbName){
		MongoClient client = GGMongoClientPool.pool.getMongoClient(dbName);
		return client.getDatabase(GGConfigurer.get("ggmongodb."+dbName+".name"));
	}
	public static MongoCollection<Document> getDBCollection(String dbName, String collection){
		try{
			return getDB(dbName).getCollection(collection);
		}catch(RuntimeException e){
			return null;
		}
	}
}
