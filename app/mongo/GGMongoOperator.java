package mongo;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.bson.Document;

import utils.GGLogger;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.ListIndexesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.IndexModel;
import com.mongodb.client.model.IndexOptions;
/**
 * 
 * @Description:对数据库操作集合类
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月17日 下午7:32:26
 */
public class GGMongoOperator {

	/**
	 * 
	 * @Description:创建索引
	 * @author yaomy
	 * @date 2017年8月17日 下午7:30:54
	 */
	public static String createIndex(MongoCollection<Document> collection, Document indexes){
		return collection.createIndex(indexes);
	}
	/**
	 * 
	 * @Description:以后台的方式创建索引
	 * @author yaomy
	 * @date 2017年8月17日 下午7:30:37
	 */
	public static String createIndexBackGround(MongoCollection<Document> collection, Document indexes){
		IndexOptions options = new IndexOptions();
		options.background(true);
		return collection.createIndex(indexes, options);
	}
	/**
	 * 
	 * @Description:创建索引根据给定的集合
	 * @author yaomy
	 * @date 2017年8月17日 下午7:30:13
	 */
	public static List<String> createIndex(MongoCollection<Document> collection, List<IndexModel> indexes){
		return collection.createIndexes(indexes);
	}
	/**
	 * 
	 * @Description:删除指定集合的指定索引
	 * @author yaomy
	 * @date 2017年8月17日 下午7:29:53
	 */
	public static void dropIndex(MongoCollection<Document> collection, Document indexes){
		try{
			collection.dropIndex(indexes);
		}catch(RuntimeException e){
			GGLogger.error("删除索引异常");
		}
	}
	/**
	 * 
	 * @Description:删除指定集合的所有索引
	 * @author yaomy
	 * @date 2017年8月17日 下午7:29:31
	 */
	public static void dropIndexAll(MongoCollection<Document> collection){
		try{
			collection.dropIndexes();
		}catch(RuntimeException e){
			GGLogger.error("删除索引异常");
		}
	}
	/**
	 * 
	 * @Description:获取指定集合的所有索引
	 * @author yaomy
	 * @date 2017年8月17日 下午7:29:01
	 */
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
	/**
	 * 
	 * @Description:查询指定字段的不同值
	 * @author yaomy
	 * @date 2017年8月17日 下午7:28:37
	 */
	public static <T> DistinctIterable<T> distinct(MongoCollection<Document> collection, String fieldName, Class<T> classType){
		return collection.distinct(fieldName, classType);
	}
	/**
	 * 
	 * @Description:根据查询条件查询指定字段的不同值
	 * @author yaomy
	 * @date 2017年8月17日 下午5:38:28
	 */
	public static <T> DistinctIterable<T> distinct(MongoCollection<Document> collection, Document query, String fieldName, Class<T> classType){
		return collection.distinct(fieldName, query, classType);
	}
}
