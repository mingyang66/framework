
package framework.yaomy.mongo.pool;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import framework.yaomy.log.GGLogger;

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
	/**
	 * 
	 * @Description:判断游标的下一个文档是否存在
	 * @param TODO
	 * @author yaomingyang
	 * @date 2017年8月20日 下午6:55:23
	 */
	public boolean hasNext(){
		if(this.mc == null){
			this.mc = this.it.iterator();
		}
		return this.mc.hasNext();
	}
	/**
	 * 
	 * @Description:查看油标的下一个文档
	 * @author yaomingyang
	 * @date 2017年8月20日 下午6:55:01
	 */
	public Document next(){
		if(this.mc == null){
			this.mc = this.it.iterator();
		}
		return this.mc.next();
	}
	/**
	 * 
	 * @Description:获取油标对应的下一个元素
	 * @author yaomingyang
	 * @date 2017年8月20日 下午6:49:54
	 */
	public Document tryNext(){
		if(this.mc == null) {
			this.mc = this.it.iterator();
		}
		return this.mc.tryNext();
	}
	/**
	 * 
	 * @Description:关闭油标
	 * @author yaomingyang
	 * @date 2017年8月20日 下午6:53:29
	 */
	public void close(){
		if(this.mc == null){
			this.mc.close();
			this.mc = null;
		}
		this.collection = null;
		this.it = null;
	}
	/**
	 * 
	 * @Description:查看油标对应的文档个数
	 * @author yaomingyang
	 * @date 2017年8月20日 下午6:54:00
	 */
	public long count(){
	  if (this.filter == null) {
		  return this.collection.count();
	  }
	  return this.collection.count(this.filter);
	}
	/**
	 * 
	 * @Description:获取数据库服务器对象
	 * @author yaomingyang
	 * @date 2017年8月20日 下午7:00:11
	 */
	public ServerAddress getServerAddress(){
		if(this.mc == null) {
			this.mc = this.it.iterator();
		}
		return this.mc.getServerAddress();
	}
	public String toString(){
		return this.it.toString();
	}
}
