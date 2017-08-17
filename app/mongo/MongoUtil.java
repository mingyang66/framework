package mongo;

import java.util.List;

import net.sf.json.JSONObject;

import org.bson.Document;

import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.IndexModel;

public class MongoUtil {

	public static MongoCollection<Document> getGGUserCollection(String collection){
		return GGMongoCollection.getDBCollection("userdb", collection);
	}
	/**
	 * 
	 * @Description:获取指定数据库的所有集合名称
	 * @author yaomy
	 * @date 2017年8月17日 下午8:00:52
	 */
	public static MongoIterable<String> listCollectionNames(){
		return GGMongoCollection.listCollectionNames("userdb");
	}
	/**
	 * 
	 * @Description:获取数据库中的所有集合对象对应的所有基本信息
	 * @author yaomy
	 * @date 2017年8月17日 下午8:04:29
	 */
	public static ListCollectionsIterable<Document> listCollections(){
		return GGMongoCollection.listCollections("userdb");
	}
	/**
	 * 
	 * @Description:TODO
	 * @author yaomy
	 * @date 2017年8月17日 下午8:13:40
	 */
	public static <T> ListCollectionsIterable<T> listCollections(Class<T> resultClass){
		return GGMongoCollection.listCollections("userdb", resultClass);
	} 
}
