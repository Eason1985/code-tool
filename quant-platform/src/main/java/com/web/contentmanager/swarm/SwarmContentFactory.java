package com.web.contentmanager.swarm;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.web.common.exception.BusinessException;

class SwarmContentFactory {
	
	/**
	 * Post方式请求swarm
	 * @param url
	 * @param paramHandle
	 */
	public static void  applyHttpPost(String url , HttpParamHandle paramHandle){
		CloseableHttpResponse  httpResponse = null  ;
		try {
			final HttpPost httpPost=new HttpPost(url);
			final JSONObject jsonParam = new JSONObject();  
			paramHandle.assimbleParam(jsonParam);
			StringEntity stringEntity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题    
			stringEntity.setContentEncoding("UTF-8");    
			stringEntity.setContentType("application/json");    
		    httpPost.setEntity(stringEntity);
			httpResponse = HttpClients.createDefault().execute(httpPost);
			HttpEntity entity = httpResponse.getEntity();  
			if (entity != null) {  
				 paramHandle.obtainResult(EntityUtils.toString(entity, "UTF-8") );
            }
		} catch (ClientProtocolException e) {
			throw new BusinessException("",e);
		} catch (IOException e) {
			throw new BusinessException("",e);
		} finally{
			if(httpResponse != null ){
				try {
					httpResponse.close();
				} catch (IOException e) {
				} 
			}
		}
	}
	
	/**
	 * Get方式请求swarm
	 * @param url
	 * @param paramHandle
	 * @return
	 */
	public static void applyHttpGet(String url , HttpParamHandle paramHandle){
		HttpGet httpGet=new HttpGet(url);
		try {
			CloseableHttpResponse  httpResponse = HttpClients.createDefault().execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();  
			if (entity != null) {  
				 paramHandle.obtainResult(EntityUtils.toString(entity, "UTF-8") );
            }
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("",e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new BusinessException("",e);
		}
		
	}
	
	
	
	
	
	public interface HttpParamHandle {

		/**
		 * eg. params.add(new BasicNameValuePair("pwd","2544"));
		 * @param nameValuePair
		 */
		void assimbleParam( final JSONObject jsonParam   );
		
		/**
		 * 从httpresponse中获取参数
		 * @param httpResponse
		 */
		void obtainResult(final String result) ; 
		
	}
	
	
}
