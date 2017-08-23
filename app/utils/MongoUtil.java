package utils;

import framework.yaomy.mongo.pool.DBCollection;
import framework.yaomy.mongo.pool.GGMongoOperator;

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
