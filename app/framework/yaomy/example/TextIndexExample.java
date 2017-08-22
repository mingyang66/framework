
package framework.yaomy.example;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import framework.yaomy.config.GGConfigurer;
import framework.yaomy.mongo.DBCollection;
import framework.yaomy.mongo.DBCursor;
import framework.yaomy.mongo.GGMongoClientPool;
import framework.yaomy.mongo.GGMongoClients;
import framework.yaomy.mongo.GGMongoOperator;
import framework.yaomy.mongo.WriteResult;

/**
 * @Description:文本索引demo
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月22日 上午11:23:12
 */
public class TextIndexExample {

	public static void main(String[] args) {
		GGConfigurer.load("conf/application.conf");
		GGMongoClientPool.pool.initPool(GGMongoClients.getClients());
		
		DBCollection collection = GGMongoOperator.getGGBusinessDBCollection("stores");
		
		List<Document> list = new ArrayList<Document>();
		Document doc1 = GGMongoOperator.newId(collection);
		doc1.append("name", "Java Hut");
		doc1.append("description", "Coffee and cakes");
		list.add(doc1);
		
		Document doc2 = GGMongoOperator.newId(collection);
		doc2.append("name", "Burger Buns");
		doc2.append("description", "Gourmet hamburgers");
		list.add(doc2);
		
		Document doc3 = GGMongoOperator.newId(collection);
		doc3.append("name", "Coffee Shop");
		doc3.append("description", "Just coffee");
		list.add(doc3);
		
		Document doc4 = GGMongoOperator.newId(collection);
		doc4.append("name", "Clothes Clothes Clothes");
		doc4.append("description", "Discount clothing");
		list.add(doc4);
		
		Document doc5 = GGMongoOperator.newId(collection);
		doc5.append("name", "Java Shopping");
		doc5.append("description", "Indonesian goods");
		list.add(doc5);
		
		WriteResult result = collection.insertMany(list);
		
		System.out.println(result.getModifiedCount());
		
		Document index = new Document();
		index.append("name", "text");
		index.append("description", "text");
		/**
		 * 创建文本索引
		 */
		String indexResult = collection.createIndexBackGround(index);
		System.out.println(indexResult);
		/**
		 * 包含java shop 但是不包含coffee
		 */
//		String s = "java shop -coffee";
		/**
		 * 包含java 或者 coffe 或者 shop
		 */
		String s = "java coffee shop 你好";
		/**
		 * 包含Java 或者 "coffee shop"
		 */
//		String s = "Java \"coffee shop\"";
		Document doc = new Document();
		doc.append("$text", new Document("$search", s));
		Document keys = new Document("score", new Document("$meta", "textScore"));
		/**
		 * 排序
		 */
		Document sort = new Document();
		sort.append("score", new Document("$meta", "textScore"));
		
		DBCursor cursor = collection.find(doc, keys).sort(sort);
		while(cursor.hasNext()){
			Document obj = cursor.next();
			System.out.println(obj.toJson());
		}
		cursor.close();
	}
}
