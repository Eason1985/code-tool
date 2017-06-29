package com.acjkj.weixinutil;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.http.SimplePostRequestExecutor;
import me.chanjar.weixin.mp.api.WxMpService;

public class MyWxMpServiceImpl implements MyWxMpService{
	static Logger logger = Logger.getLogger(MyWxMpServiceImpl.class);
	WxMpService wxMpService;
	
	public MyWxMpServiceImpl(){
		
	}
	
	public MyWxMpServiceImpl(WxMpService wxMpService){
		this.wxMpService=wxMpService;
	}
	
	/**
	 * 获得模板ID
	 * https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN
	 *  post:
	 *  {
           "template_id_short":"TM00015"
        }
        
                 结果:
       {
           "errcode":0,
           "errmsg":"ok",
           "template_id":"Doclyl5uP7Aciu-qZ7mJNPtWkbkYnWBWVja26EGbNyk"
       }
	 * @throws WxErrorException 
	 */
	public String  getTemplateId(String template_id_short){
		 String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template";
		 Map map = new MyMap();
		 map.put("template_id_short", template_id_short);
		 Map result = map;
		 String json=null;
		try {
			 json = wxMpService.post( url, map.toString());
			 result = JsonBinder.buildNonDefaultBinder().fromJson(json, HashMap.class);
			 if(!"ok".equals(map.get("errmsg"))){
				 logger.error(map);
			 }
		} catch (WxErrorException e) {
			logger.error("获得消息模板id错误",e);
		}
		
		return (String) result.get("template_id");
	}
}
