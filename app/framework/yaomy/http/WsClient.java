package framework.yaomy.http;

import java.util.HashMap;
import java.util.Map;

import play.libs.WS;
import play.libs.WS.HttpResponse;

import com.google.gson.JsonElement;

public class WsClient {

	/**
	 * 通过POST方式调用远程接口
	 * @param url 请求路径
	 * @param params 参数
	 * @return
	 */
	public static JsonElement requestByPost(String url, Map<String, String> params){
    	if(params == null){
    		params = new HashMap<String, String>();
    	}
		HttpResponse ws = WS.url(url)
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
		if(params == null){
			params = new HashMap<String, String>();
		}
		
		HttpResponse ws = WS.url(url)
				.setParameters(params)
				.get();
		JsonElement json = ws.getJson();
		return json;
	}
}
