
package controllers;

import org.bson.Document;

import framework.yaomy.config.GGConfigurer;
import framework.yaomy.log.GGLogger;
import framework.yaomy.mongo.pool.DBCollection;
import framework.yaomy.mongo.pool.DBCursor;
import framework.yaomy.mongo.pool.GGMongoClientPool;
import framework.yaomy.mongo.pool.GGMongoClients;
import framework.yaomy.util.MongoUtil;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年9月27日 下午4:10:21
 */
public class CompareIndexId {

	public static void main(String[] args) {
		 GGConfigurer.load("conf/application.conf");
		 GGMongoClientPool.pool.initPool(GGMongoClients.getClients());
		 GGLogger.info("数据库初始化成功...");
		 
//		 DBCollection collection = MongoUtil.getGGUserCollection("gg_ids");//-------------修改
//		 DBCollection collection = MongoUtil.getGGStockCollection("gg_ids");//-------------修改
//		 DBCollection collection = MongoUtil.getGGStockBaseCollection("gg_ids");//-------------修改
//		 DBCollection collection = MongoUtil.getGGIndustrydbCollection("gg_ids");//-------------修改
		 DBCollection collection = MongoUtil.getGGF10dbCollection("gg_ids");//-------------修改
		 DBCursor cursor = collection.find();
		 int i=1;
		 while(cursor.hasNext()){
			 Document obj = cursor.next();
			 Long ggids = Long.parseLong(obj.get("id").toString());
			 String collectionName = obj.getString("name");
			 try{
				 Object collId = find(collectionName);
				 if(collId != null){
					 if(ggids<(long)collId){
						 System.out.println(collectionName+"-----"+ggids + "----------"+ collId+"--"+(i++)+"--"+(ggids>=(long)collId));
					 }
				 }
//			 System.out.println(obj.getString("name")+"--"+ggids+"======="+cursor.count()+"=="+(i++));
			 }catch(Exception e){
				 System.out.println(ggids+"---异常---"+collectionName);
			 }
		 }
		 cursor.close();
	}
	public static Object find(String collectionName){
//		DBCollection collection = MongoUtil.getGGUserCollection(collectionName);//-------------修改
//		DBCollection collection = MongoUtil.getGGStockCollection(collectionName);//-------------修改
//		DBCollection collection = MongoUtil.getGGStockBaseCollection(collectionName);//-------------修改
//		DBCollection collection = MongoUtil.getGGIndustrydbCollection(collectionName);//-------------修改
		DBCollection collection = MongoUtil.getGGF10dbCollection(collectionName);//-------------修改
		Document sort = new Document();
		sort.append("_id", -1);
		
		DBCursor cursor = collection.find().sort(sort).limit(1);
		if(cursor.hasNext()){
			Document doc = cursor.next();
			Object id = doc.get("_id");
			return id;
		}
		cursor.close();
		return null;
	}
}
