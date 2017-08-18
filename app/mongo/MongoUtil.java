package mongo;

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
}
