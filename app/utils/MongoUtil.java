package utils;

import ggframework.yaomy.mongo.DBCollection;
import ggframework.yaomy.mongo.GGMongoOperator;

import java.util.List;

import net.sf.json.JSONObject;

import org.bson.Document;

import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.IndexModel;

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
