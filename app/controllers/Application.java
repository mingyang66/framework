package controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mongo.GGMongoOperator;
import mongo.MongoUtil;
import net.sf.json.JSONObject;

import org.bson.Document;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.mvc.Controller;
import utils.SignHelper;

import com.google.gson.JsonElement;
import com.mongodb.DBObject;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.CountOptions;

public class Application extends Controller {

    public static void GetJson() {
//    	MongoCollection<Document> collection = GGMongoOperator.getDBCollection("userdb", "a_object");
//    	MongoCursor<Document> cursor = collection.find().iterator();
//    	List<String> list = new  ArrayList<String>();
//    	while(cursor.hasNext()){
//    		Document doc = cursor.next();
//    		System.out.println(doc);
//    		list.add(doc.toJson());
//    	}
//    	cursor.close();
    	
    	
    	Document doc = new Document();
    	doc.append("product_code", new Document("$in", Arrays.asList(18,19)));
    	MongoCollection<Document> collection = MongoUtil.getGGUserCollection("a_product_line");
    	ListCollectionsIterable<Document> it = MongoUtil.listCollections();
    	MongoCursor<Document> cursor = it.iterator();
    	while(cursor.hasNext()){
    		Document o = cursor.next();
    		System.out.println(o);
    		System.out.println(o.getString("key"));
    	}
    	cursor.close();
        renderJSON("21");
    }

 
    public static void ws(){
    	String url = "http://ggservice.sandbox.gofund.com.cn/v1/user/login";
    	long timeStamp = System.currentTimeMillis() / 1000;
    	
		Map<String, String> params = new HashMap<String, String>();
		params.put("login_name", "E00000203");
		params.put("password", "619868");
		params.put("app_key", "GLrfgoNIGnAiKRp");
		params.put("time_stamp", String.valueOf(timeStamp));
	
		String sign = getSign("GLrfgoNIGnAiKRp", "GnqBxvbgtGIsWEhvinUsf5Fdl64gsZyc", timeStamp, params, "v1/user/login", "GET");
		params.put("sign", sign);
		
		HttpResponse ws = WS.url(url)
							.setParameters(params)
							.get();
		JsonElement json = ws.getJson();
//		new MyJob().now();
		renderText(json);
	}
	private static String getSign(String appKey, String appSecret, Long timeStamp, Map<String, String> params, String url, String requestMethod) {
        Map paramsMap = new HashMap();
        if (params != null) {
        	paramsMap.putAll(params);
        }
        paramsMap.put("app_key", appKey);
        paramsMap.put("time_stamp", timeStamp.toString());
        paramsMap.remove("sign");
        SignHelper.codePayValue(paramsMap);
        try {
            return SignHelper.makeSign(requestMethod, url, paramsMap, appSecret);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }
}