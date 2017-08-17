package mongo;

import java.util.List;

import net.sf.json.JSONObject;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexModel;

public class MongoUtil {

	public static MongoCollection<Document> getGGUserCollection(String collection){
		return GGMongoOperator.getDBCollection("userdb", collection);
	}
	public static String createGGIndexBackGround(MongoCollection<Document> collection, Document indexes){
		return GGMongoIndexs.createIndexBackGround(collection, indexes);
	}
	public static String createGGIndex(MongoCollection<Document> collection, Document indexes){
		return GGMongoIndexs.createIndex(collection, indexes);
	}
	public static List<String> createGGIndex(MongoCollection<Document> collection, List<IndexModel> indexes){
		return GGMongoIndexs.createIndex(collection, indexes);
	}
	public static void dropGGIndex(MongoCollection<Document> collection, Document indexes){
		GGMongoIndexs.dropIndex(collection, indexes);
	}
	public static void dropGGIndexAll(MongoCollection<Document> collection){
		GGMongoIndexs.dropIndexAll(collection);
	}
	public static List<JSONObject> listGGIndexes(MongoCollection<Document> collection){
		return GGMongoIndexs.listIndexs(collection);
	}
}
