package com.acjkj.weixinutil.deprecated;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;


@Deprecated
public class StoreMpInfo {
	
	//记录id
	private    String   id ;
	//网点
	private    String   orgId ;
	//公众号secret
	private    String   appSecret ;
	//公众号appId
	private    String   appId ;
	//公众号token
	private    String   token ;
	//公众号的AESKey
	private    String   aeskey ;
	//微信号
	private    String   wechatCode ;
	//创建人id
	private    String   createUserId ;
	//更新人id
	private    String   updateUserId ;
	//更新时间
	private    String   updateTime ;
	//创建时间
	private    String   createTime ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAeskey() {
		return aeskey;
	}
	public void setAeskey(String aeskey) {
		this.aeskey = aeskey;
	}
 
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getWechatCode() {
		return wechatCode;
	}
	public void setWechatCode(String wechatCode) {
		this.wechatCode = wechatCode;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	
}
