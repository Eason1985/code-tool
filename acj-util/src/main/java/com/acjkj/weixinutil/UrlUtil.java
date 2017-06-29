package com.acjkj.weixinutil;

import me.chanjar.weixin.common.util.http.URIUtil;

public class UrlUtil {
	 public static String oauth2buildAuthorizationUrl(String appid,String url2,String scope, String state) {
		  
		  
		    String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" ;
		    url += "appid=" +appid;
		    url += "&redirect_uri=" + URIUtil.encodeURIComponent(url2);
		    url += "&response_type=code";
		    url += "&scope=" + scope;
		    if (state != null) {
		      url += "&state=" + state;
		    }
		    url += "#wechat_redirect";
		    return url;
		  }
}
