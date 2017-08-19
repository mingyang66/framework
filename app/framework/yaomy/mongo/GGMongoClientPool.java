package framework.yaomy.mongo;

import java.util.Map;

import com.mongodb.MongoClient;

public enum GGMongoClientPool {

	pool;
	
	private Map<String, MongoClient> clients = null;
	
	public void initPool(Map<String, MongoClient> clients){
		this.clients = clients;
	}
	
	public void destoryPool(){
		if(this.clients != null){
			for(Map.Entry<String, MongoClient> client : this.clients.entrySet()){
				client.getValue().close();
			}
		}
	}
	
	public MongoClient getMongoClient(String db){
		if ((this.clients == null) || (this.clients.isEmpty())) {
			  return null;
		}
		return this.clients.get(db);
	}
}
