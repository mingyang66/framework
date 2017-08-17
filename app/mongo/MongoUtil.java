package mongo;

import java.util.List;

import net.sf.json.JSONObject;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexModel;

public class MongoUtil {

	public static MongoCollection<Document> getGGUserCollection(String collection){
		return GGMongoCollection.getDBCollection("userdb", collection);
	}
}
