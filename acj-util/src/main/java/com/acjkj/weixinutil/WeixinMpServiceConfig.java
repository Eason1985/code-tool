package com.acjkj.weixinutil;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;

public class WeixinMpServiceConfig {
	public WxMpConfigStorage wxMpConfigStorage;
	public WxMpService wxMpService;
	public MyWxMpService myWxMpService;
	public WxMpMessageRouter wxMpMessageRouter;

	public WeixinMpServiceConfig() {
		super();
	}

	public WeixinMpServiceConfig(WxMpConfigStorage wxMpConfigStorage,WxMpService wxMpService, WxMpMessageRouter wxMpMessageRouter) {
		super();
		this.wxMpConfigStorage = wxMpConfigStorage;
		this.wxMpService = wxMpService;
		this.myWxMpService = new MyWxMpServiceImpl(wxMpService);
		this.wxMpMessageRouter = wxMpMessageRouter;
	}

	public MyWxMpInMemoryConfigStorage getMyWxMpInMemoryConfigStorage() {
		return (MyWxMpInMemoryConfigStorage)wxMpConfigStorage;
	}
	
	public WxMpConfigStorage getWxMpConfigStorage() {
		return wxMpConfigStorage;
	}

	public void setWxMpConfigStorage(WxMpConfigStorage wxMpConfigStorage) {
		this.wxMpConfigStorage = wxMpConfigStorage;
	}

	public WxMpService getWxMpService() {
		return wxMpService;
	}

	public void setWxMpService(WxMpService wxMpService) {
		this.wxMpService = wxMpService;
		this.myWxMpService = new MyWxMpServiceImpl(wxMpService);
	}

	public WxMpMessageRouter getWxMpMessageRouter() {
		return wxMpMessageRouter;
	}

	public void setWxMpMessageRouter(WxMpMessageRouter wxMpMessageRouter) {
		this.wxMpMessageRouter = wxMpMessageRouter;
	}

	public MyWxMpService getMyWxMpService() {
		return myWxMpService;
	}

	public void setMyWxMpService(MyWxMpService myWxMpService) {
		this.myWxMpService = myWxMpService;
	}

}