package utils;

import java.util.List;

import net.sf.json.JSONObject;

import org.bson.Document;

import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.IndexModel;

import framework.yaomy.mongo.DBCollection;
import framework.yaomy.mongo.GGMongoOperator;

public class MongoUtil {

	public static DBCollection getGGUserCollection(String collection){
		return GGMongoOperator.getDBCollection("userdb", collection);
	}
	public static DBCollection getGGIndexCollection(String collection){
		return GGMongoOperator.getDBCollection("indexdb", collection);
	}
	public static DBCollection getGGStockCollection(String collection){
		return GGMongoOperator.getDBCollection("ggstockdb", collection);
	}
}
