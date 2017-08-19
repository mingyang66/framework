
package framework.yaomy.mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月18日 下午4:55:57
 */
public class DBCursor {

	private MongoCollection<Document> collection;
	private Bson filter;
	private FindIterable<Document> it;
	private MongoCursor<Document> mc;
	DBCursor(MongoCollection<Document> collection, Bson filter, FindIterable<Document> it) {
		this.collection = collection;
		this.filter = filter;
		this.it = it;
	}
	public DBCursor limit(int limit){
		this.it = this.it.limit(limit);
		return this;
	}
	public DBCursor skip(int skip){
		this.it = this.it.skip(skip);
		return this;
	}
	public DBCursor sort(Document sort){
		this.it = this.it.sort(sort);
		return this;
	}
	public boolean hasNext(){
		if(this.mc == null){
			this.mc = this.it.iterator();
		}
		return this.mc.hasNext();
	}
	public Document next(){
		if(this.mc == null){
			this.mc = this.it.iterator();
		}
		return this.mc.next();
	}
	public void close(){
		if(this.mc == null){
			this.mc.close();
			this.mc = null;
		}
		this.collection = null;
		this.it = null;
	}
	public long count(){
	  if (this.filter == null) {
		  return this.collection.count();
	  }
	  return this.collection.count(this.filter);
	}
	public String toString(){
		return this.it.toString();
	}
}
