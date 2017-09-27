package framework.yaomy.util;

import framework.yaomy.mongo.pool.DBCollection;
import framework.yaomy.mongo.pool.GGMongoOperator;

public class MongoUtil {

	public static DBCollection getGGUserCollection(String collection){
		return GGMongoOperator.getDBCollection("userdb", collection);
	}
	public static DBCollection getGGStockBaseCollection(String collection){
		return GGMongoOperator.getDBCollection("stockbasedb", collection);
	}
	public static DBCollection getGGStockCollection(String collection){
		return GGMongoOperator.getDBCollection("ggstockdb", collection);
	}
	public static DBCollection getGGIndustrydbCollection(String collection){
		return GGMongoOperator.getDBCollection("industrydb", collection);
	}
	public static DBCollection getGGF10dbCollection(String collection){
		return GGMongoOperator.getDBCollection("ggf10db", collection);
	}
}
