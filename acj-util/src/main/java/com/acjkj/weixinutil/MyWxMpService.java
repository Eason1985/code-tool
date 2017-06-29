package com.acjkj.weixinutil;

import me.chanjar.weixin.common.exception.WxErrorException;

public interface  MyWxMpService {
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
	public String  getTemplateId(String template_id_short);		
}
