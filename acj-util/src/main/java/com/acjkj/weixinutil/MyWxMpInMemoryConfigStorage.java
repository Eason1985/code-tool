package com.acjkj.weixinutil;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

public class MyWxMpInMemoryConfigStorage extends WxMpInMemoryConfigStorage {
	private String accountStoreId;

	public String getAccountStoreId() {
		return accountStoreId;
	}

	public void setAccountStoreId(String accountStoreId) {
		this.accountStoreId = accountStoreId;
	}
	
	
}
