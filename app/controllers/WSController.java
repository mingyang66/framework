package controllers;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;

import play.libs.WS;
import play.libs.WS.HttpResponse;

public class WSController {

	public static void ws(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("app_key", "GLrfgoNIGnAiKRp");
		params.put("sign", "GnqBxvbgtGIsWEhvinUsf5Fdl64gsZyc");
		params.put("time_stamp", String.valueOf(System.currentTimeMillis()));
		params.put("login_name", "E00000203");
		params.put("password", "619868");
		
		HttpResponse ws = WS.url("http://ggservice.sandbox.gofund.com.cn/v1/user/login")
							.setParameters(params)
							.get();
		JsonElement json = ws.getJson();
		System.out.println(json);
	}
}
