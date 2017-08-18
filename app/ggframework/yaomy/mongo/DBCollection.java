
package ggframework.yaomy.mongo;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.bson.Document;

import utils.GGLogger;

import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.ListIndexesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.CountOptions;
import com.mongodb.client.model.IndexModel;
import com.mongodb.client.model.IndexOptions;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月18日 上午9:27:13
 */
public class DBCollection{

	 private MongoDatabase db;
	 private MongoCollection<Document> collection = null;
	 
	 DBCollection(MongoDatabase db, MongoCollection<Document> collection) {
		 this.db = db;
		 this.collection = collection;
	 }

	public MongoDatabase getDb() {
		return db;
	}

	public void setDb(MongoDatabase db) {
		this.db = db;
	}

	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}


	/**
	 * 
	 * @Description:创建索引
	 * @author yaomy
	 * @date 2017年8月17日 下午7:30:54
	 */
	public String createIndex(Document indexes){
		return collection.createIndex(indexes);
	}
	/**
	 * 
	 * @Description:以后台的方式创建索引
	 * @author yaomy
	 * @date 2017年8月17日 下午7:30:37
	 */
	public String createIndexBackGround(Document indexes){
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
	public List<String> createIndex(List<IndexModel> indexes){
		return collection.createIndexes(indexes);
	}
	/**
	 * 
	 * @Description:删除指定集合的指定索引
	 * @author yaomy
	 * @date 2017年8月17日 下午7:29:53
	 */
	public void dropIndex(Document indexes){
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
	public void dropIndexAll(MongoCollection<Document> collection){
		try{
			collection.dropIndexes();
		}catch(RuntimeException e){
			GGLogger.error("删除索引异常");
		}
	}
	/**
	 * 
	 * @Description:查询所有的文档集合
	 * @author yaomy
	 * @date 2017年8月18日 上午10:53:36
	 */
	public FindIterable<Document> findAll(){
		return collection.find();
	}
	/**
	 * 
	 * @Description:根据条件查询文档集合
	 * @author yaomy
	 * @date 2017年8月18日 上午10:52:34
	 */
	public FindIterable<Document> find(Document query){
		return collection.find(query);
	}
	/**
	 * 
	 * @Description:获取指定集合的所有索引
	 * @author yaomy
	 * @date 2017年8月17日 下午7:29:01
	 */
	public List<JSONObject> listIndexs(MongoCollection<Document> collection){
		
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
	public <T> DistinctIterable<T> distinct(String fieldName, Class<T> classType){
		return collection.distinct(fieldName, classType);
	}
	/**
	 * 
	 * @Description:根据查询条件查询指定字段的不同值
	 * @author yaomy
	 * @date 2017年8月17日 下午5:38:28
	 */
	public <T> DistinctIterable<T> distinct(Document query, String fieldName, Class<T> classType){
		return collection.distinct(fieldName, query, classType);
	}
	/**
	 * 
	 * @Description:计算集合中的文档数
	 * @author yaomy
	 * @date 2017年8月17日 下午7:39:56
	 */
	public long count(MongoCollection<Document> collection){
		return collection.count();
	}
	/**
	 * 
	 * @Description:根据指定的过滤器查询符合条件的文档数
	 * @author yaomy
	 * @date 2017年8月17日 下午7:41:08
	 */
	public long count(Document query){
		return collection.count(query);
	}
	/**
	 * 
	 * @Description:根据指定的过滤器和计数选项查询符合条件的文档数
	 * @author yaomy
	 * @date 2017年8月17日 下午7:47:08
	 */
	public long count(Document query, CountOptions options){
		return collection.count(query, options);
	}

	/**
	 * 
	 * @Description:获取指定数据库的所有集合名称
	 * @author yaomy
	 * @date 2017年8月17日 下午8:00:52
	 */
	public MongoIterable<String> listCollectionNames(){
		return db.listCollectionNames();
	}
	/**
	 * 
	 * @Description:获取数据库中的所有集合对象对应的所有基本信息
	 * @author yaomy
	 * @date 2017年8月17日 下午8:04:29
	 */
	public ListCollectionsIterable<Document> listCollections(){
		return db.listCollections();
	}
	/**
	 * 
	 * @Description:TODO
	 * @author yaomy
	 * @date 2017年8月17日 下午8:13:40
	 */
	public <T> ListCollectionsIterable<T> listCollections(Class<T> resultClass){
		return db.listCollections(resultClass);
	}
}
