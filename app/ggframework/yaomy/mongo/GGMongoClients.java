package ggframework.yaomy.mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import ggframework.yaomy.config.GGConfigurer;

public class GGMongoClients {
	/**
	 * 获取client
	 * @return
	 */
	public static Map<String, MongoClient> getClients(){
		Map<String, MongoClient> clients = new HashMap<String, MongoClient>();
		String seeds = GGConfigurer.get("ggmongodb.business.seeds");
		
		MongoClientOptions options = configMongoClient();
		List<String> dbs = new ArrayList<String>();
		if(GGConfigurer.containsKey("ggmongodb.dbs")){
			String[] arr = GGConfigurer.get("ggmongodb.dbs").split(",");
	        for (String id : arr) {
	         if (StringUtils.isNotBlank(id)) {
	           dbs.add(id);
	         }
	       }
		}
		
		
		Map<String, List<ServerAddress>> addressLists = new HashMap<String, List<ServerAddress>>();
	    for (String db : dbs) {
	    	String[] addrs2 = GGConfigurer.get("ggmongodb.business.seeds").split(",");
	       if (GGConfigurer.containsKey("ggmongodb." + db + ".seeds") && (!GGConfigurer.get("ggmongodb." + db + ".seeds").equals(seeds))) {
	    	   addrs2 = GGConfigurer.get("ggmongodb." + db + ".seeds").split(",");
	       }
	       if(addrs2 != null){
	    	   List<ServerAddress> addressList2 = new ArrayList<ServerAddress>();
	    	   for (String addr : addrs2) {
	    		   if (StringUtils.isNotBlank(addr)) {
	    			   addressList2.add(new ServerAddress(addr.split(":")[0], Integer.parseInt(addr.split(":")[1])));
	    		   }
	    	   }
	    	   addressLists.put(db, addressList2);
	       }
	     }
	    
	     Map<String, List<MongoCredential>> credentialsLists = new HashMap<String, List<MongoCredential>>();
	     Set confs = GGConfigurer.keySet();
	     for (Iterator it = confs.iterator(); it.hasNext(); ) { 
	    	 Object k = it.next();
	    	 List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
	         if ((k.toString().startsWith("ggmongodb.")) && (k.toString().endsWith(".name"))) {
	         String db = k.toString().split("\\.")[1];
	         String version = GGConfigurer.get("ggmongodb."+db+".version", "3");
	         if(StringUtils.equals(version, "2")){
	        	 //老版本2.6默认使用MONGODB_CR认证方式
	        	 credentialsList.add(MongoCredential.createMongoCRCredential(GGConfigurer.get("ggmongodb." + db + ".username"), GGConfigurer.get("ggmongodb." + db + ".name"), GGConfigurer.get("ggmongodb." + db + ".password").toCharArray()));
	         } else {
	        	 //新版本默认使用SCRAM-SHA-1认证方式
	        	 credentialsList.add(MongoCredential.createScramSha1Credential(GGConfigurer.get("ggmongodb." + db + ".username"), GGConfigurer.get("ggmongodb." + db + ".name"), GGConfigurer.get("ggmongodb." + db + ".password").toCharArray()));
	         }
	 
	         credentialsLists.put(db, credentialsList);
	       }
	     }
	    
	     for (Iterator<String> it=addressLists.keySet().iterator(); it.hasNext();) {
	    	 String db = it.next();
	    	 if(credentialsLists.get(db) == null)
	    		 continue;
	    	 if(options == null){
	    		 clients.put(db, new MongoClient(addressLists.get(db), credentialsLists.get(db)));
	    	 } else {
	    		 clients.put(db, new MongoClient(addressLists.get(db), credentialsLists.get(db), options));
	    	 }
	     }
		return clients;
	}
   private static MongoClientOptions configMongoClient() {
	     if (GGConfigurer.getBoolean("ggmongodb.defaultConfig", true)) {
	       return null;
	     }
	 
	     MongoClientOptions.Builder builder = MongoClientOptions.builder();
	     if (GGConfigurer.containsKey("ggmongodb.connectionsPerHost")) {
	       builder.connectionsPerHost(Integer.parseInt(GGConfigurer.get("ggmongodb.connectionsPerHost")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.minConnectionsPerHost")) {
	       builder.minConnectionsPerHost(Integer.parseInt(GGConfigurer.get("ggmongodb.minConnectionsPerHost")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.connectTimeout")) {
	       builder.connectTimeout(Integer.parseInt(GGConfigurer.get("ggmongodb.connectTimeout")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.maxWaitTime")) {
	       builder.maxWaitTime(Integer.parseInt(GGConfigurer.get("ggmongodb.maxWaitTime")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.maxConnectionIdleTime")) {
	       builder.maxConnectionIdleTime(Integer.parseInt(GGConfigurer.get("ggmongodb.maxConnectionIdleTime")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.maxConnectionLifeTime")) {
	       builder.maxConnectionLifeTime(Integer.parseInt(GGConfigurer.get("ggmongodb.maxConnectionLifeTime")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.socketKeepAlive")) {
	       builder.socketKeepAlive(Boolean.parseBoolean(GGConfigurer.get("ggmongodb.socketKeepAlive")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.socketTimeout")) {
	       builder.socketTimeout(Integer.parseInt(GGConfigurer.get("ggmongodb.socketTimeout")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.heartbeatSocketTimeout")) {
	       builder.heartbeatSocketTimeout(Integer.parseInt(GGConfigurer.get("ggmongodb.heartbeatSocketTimeout")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.heartbeatConnectTimeout")) {
	       builder.heartbeatConnectTimeout(Integer.parseInt(GGConfigurer.get("ggmongodb.heartbeatConnectTimeout")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.heartbeatFrequency")) {
	       builder.heartbeatFrequency(Integer.parseInt(GGConfigurer.get("ggmongodb.heartbeatFrequency")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.minHeartbeatFrequency")) {
	       builder.minHeartbeatFrequency(Integer.parseInt(GGConfigurer.get("ggmongodb.minHeartbeatFrequency")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.threadsAllowedToBlockForConnectionMultiplier")) {
	       builder.threadsAllowedToBlockForConnectionMultiplier(Integer.parseInt(GGConfigurer.get("ggmongodb.threadsAllowedToBlockForConnectionMultiplier")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.cursorFinalizerEnabled")) {
	       builder.cursorFinalizerEnabled(Boolean.parseBoolean(GGConfigurer.get("ggmongodb.cursorFinalizerEnabled")));
	     }
	     if (GGConfigurer.containsKey("ggmongodb.alwaysUseMBeans")) {
	       builder.alwaysUseMBeans(Boolean.parseBoolean(GGConfigurer.get("ggmongodb.alwaysUseMBeans")));
	     }
	     return builder.build();
	   }
}
