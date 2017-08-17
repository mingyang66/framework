package mongo;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.bson.Document;

import utils.GGLogger;

import com.mongodb.client.ListIndexesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.IndexModel;
import com.mongodb.client.model.IndexOptions;

public class GGMongoIndexs {

	public static String createIndex(MongoCollection<Document> collection, Document indexes){
		return collection.createIndex(indexes);
	}
	public static String createIndexBackGround(MongoCollection<Document> collection, Document indexes){
		IndexOptions options = new IndexOptions();
		options.background(true);
		return collection.createIndex(indexes, options);
	}
	public static List<String> createIndex(MongoCollection<Document> collection, List<IndexModel> indexes){
		return collection.createIndexes(indexes);
	}
	public static void dropIndex(MongoCollection<Document> collection, Document indexes){
		try{
			collection.dropIndex(indexes);
		}catch(RuntimeException e){
			GGLogger.error("删除索引异常");
		}
	}
	public static void dropIndexAll(MongoCollection<Document> collection){
		try{
			collection.dropIndexes();
		}catch(RuntimeException e){
			GGLogger.error("删除索引异常");
		}
	}
	public static List<JSONObject> listIndexs(MongoCollection<Document> collection){
		
		ListIndexesIterable<Document> list = collection.listIndexes();
		MongoCursor<Document> cursor = list.iterator();
		List<JSONObject> indexs = new ArrayList<JSONObject>();
		while(cursor.hasNext()){
			Document o = cursor.next();
			JSONObject json = JSONObject.fromObject(o);
			indexs.add(json.getJSONObject("key"));
		}
		cursor.close();
		
		return indexs;
	}
}
