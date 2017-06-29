package com.acjkj.weixinutil;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

public class MpServiceFactory {
	public static Map<String, WeixinMpServiceConfig> serviceMap = new Hashtable<String, WeixinMpServiceConfig>();

	public static WxMpService getWxMpService(String corpId,String appid ,String secret ,
			String token) {
		WxMpService result = null;
		WeixinMpServiceConfig config = serviceMap.get(corpId);
		if (config != null) {
			return config.getWxMpService();
		}
		final MyWxMpInMemoryConfigStorage myWxMpInMemoryConfigStorage = new MyWxMpInMemoryConfigStorage();
		myWxMpInMemoryConfigStorage.setAppId(appid);
		myWxMpInMemoryConfigStorage.setSecret(secret);
		myWxMpInMemoryConfigStorage.setToken(token);
		myWxMpInMemoryConfigStorage.setAccountStoreId(corpId);
		WxMpService wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(myWxMpInMemoryConfigStorage);
		WxMpMessageRouter wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
		WeixinMpServiceConfig weixinMpServiceConfig = new WeixinMpServiceConfig(myWxMpInMemoryConfigStorage, wxMpService,wxMpMessageRouter) ;
		result = weixinMpServiceConfig.getWxMpService() ; 
		synchronized (MpServiceFactory.serviceMap) {
			MpServiceFactory.serviceMap.put(corpId,weixinMpServiceConfig);
		}
		return result;
	}
	
	public static MyWxMpService getMyWxMpService(String corpId) {
		MyWxMpService result = null;
		WeixinMpServiceConfig config = serviceMap.get(corpId);
		if (config != null) {
			result = config.getMyWxMpService();
		}
		return result;
	}

	public static WxMpMessageRouter getWxMpMessageRouter(String corpId) {
		WxMpMessageRouter result = null;
		WeixinMpServiceConfig config = serviceMap.get(corpId);
		if (config != null) {
			result = config.getWxMpMessageRouter();
		}
		return result;
	}

	public static WxMpConfigStorage getWxMpConfigStorage(String corpId) {
		WxMpConfigStorage result = null;
		WeixinMpServiceConfig config = serviceMap.get(corpId);
		if (config != null) {
			result = config.getWxMpConfigStorage();
		}
		return result;
	}

	public static WxMpService getWxMpServiceByAccountStoreId(String accountStoreId) {
		Iterator<WeixinMpServiceConfig> configIterator = serviceMap.values().iterator();
		while(configIterator.hasNext()){
			WeixinMpServiceConfig config = configIterator.next();
			if(accountStoreId.equals(config.getMyWxMpInMemoryConfigStorage().getAccountStoreId())){
				return config.getWxMpService();
			}
		}
		return null;
	}
	
	public static WeixinMpServiceConfig getWeixinMpServiceConfigByAccountStoreId(String accountStoreId) {
		Iterator<WeixinMpServiceConfig> configIterator = serviceMap.values().iterator();
		while(configIterator.hasNext()){
			WeixinMpServiceConfig config = configIterator.next();
			if(accountStoreId.equals(config.getMyWxMpInMemoryConfigStorage().getAccountStoreId())){
				return config;
			}
		}
		return null;
	}

	public static String getAppid(String accountStoreId) {
		return MpServiceFactory.getWeixinMpServiceConfigByAccountStoreId(accountStoreId).getWxMpConfigStorage().getAppId();
	}
}
