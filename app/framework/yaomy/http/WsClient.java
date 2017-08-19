package framework.yaomy.http;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import utils.SignHelper;

public class WsClient {

	private static String URL = "http://ggservice.sandbox.gofund.com.cn/";
	private static String APPKEY = "GLrfgoNIGnAiKRp";
	private static String SECURITY = "GnqBxvbgtGIsWEhvinUsf5Fdl64gsZyc";
	/**
	 * 通过POST方式调用远程接口
	 * @param url 请求路径
	 * @param params 参数
	 * @return
	 */
	public static JsonElement requestByPost(String url, Map<String, String> params){
		url = "v1/"+url;
    	long timeStamp = System.currentTimeMillis() / 1000;
    	if(params == null){
    		params = new HashMap<String, String>();
    	}
		params.put("app_key", APPKEY);
		params.put("time_stamp", String.valueOf(timeStamp));
	
		String sign = getSign(APPKEY, SECURITY, timeStamp, params, url, "POST");
		params.put("sign", sign);
		 
		HttpResponse ws = WS.url(URL+url)
							.setParameters(params)
							.post();
		JsonElement json = ws.getJson();
		return json;
	}
	/**
	 * 通过GET方式调用远程接口
	 * @param url 请求路径
	 * @param params 请求参数
	 * @return
	 */
	public static JsonElement requestByGet(String url, Map<String, String> params){
		url = "v1/"+url;
		long timeStamp = System.currentTimeMillis() / 1000;
		if(params == null){
			params = new HashMap<String, String>();
		}
		params.put("app_key", APPKEY);
		params.put("time_stamp", String.valueOf(timeStamp));
		
		String sign = getSign(APPKEY, SECURITY, timeStamp, params, url, "GET");
		params.put("sign", sign);
		
		HttpResponse ws = WS.url(URL+url)
				.setParameters(params)
				.get();
		JsonElement json = ws.getJson();
		return json;
	}
	/**
	 * 签名
	 * @param appKey
	 * @param appSecret
	 * @param timeStamp
	 * @param params
	 * @param url
	 * @param requestMethod
	 * @return
	 */
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
