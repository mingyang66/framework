
package framework.yaomy.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import framework.yaomy.log.GGLogger;

/**
 * @Description:HttpClient客户端请求
 * @version 1.0
 * @since JDK1.7
 * @author yaomy
 * @company xxxxxxxxxxxxxx
 * @copyright (c) 2017 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2017年8月21日 上午11:22:54
 */
public class HttpClient {

	/**
	 * 
	 * @Description:获取get请求结果
	 * @author yaomy
	 * @date 2017年8月21日 上午11:44:08
	 */
	public static String requestByGet(String uri) {  
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        String content = null;
        try {  
            // 创建httpget.    
            HttpGet httpget = new HttpGet(uri);  
            GGLogger.info("executing request " + httpget.getURI());
            // 执行get请求.    
            CloseableHttpResponse response = httpclient.execute(httpget);  
            // 获取响应实体    
            HttpEntity entity = response.getEntity();  
            // 打印响应状态    
            GGLogger.info(response.getStatusLine());  
            GGLogger.info(response.getStatusLine().getStatusCode());  
            int status = response.getStatusLine().getStatusCode();
           
            if (status == 200 && entity != null) {  
                content = EntityUtils.toString(entity);
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return content;
    }  
	/**
	 * 
	 * @Description:获取post请求结果
	 * @author yaomy
	 * @date 2017年8月21日 上午11:52:17
	 */
	public static String requestByPost(String uri, Map<String, String> params) {  
        // 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost    
        HttpPost httppost = new HttpPost(uri);  
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        if(params != null){
        	for(Iterator<String> it=params.keySet().iterator();it.hasNext();){
        		String key = it.next();
        		formparams.add(new BasicNameValuePair(key, params.get(key)));  
        	}
        }
        UrlEncodedFormEntity uefEntity;  
        String content = null;
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            GGLogger.info("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            HttpEntity entity = response.getEntity();  
            // 打印响应状态    
            GGLogger.info(response.getStatusLine());  
            GGLogger.info(response.getStatusLine().getStatusCode());  
            int status = response.getStatusLine().getStatusCode();
            
            if (status == 200 && entity != null) { 
                content = EntityUtils.toString(entity, "UTF-8");
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return content;
    }  
}
