package com.acjkj.weixinutil.deprecated;
import java.text.SimpleDateFormat;

import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

import org.apache.log4j.Logger;

import com.acjkj.weixinutil.MpServiceFactory;
import com.acjkj.weixinutil.MyWxMpInMemoryConfigStorage;
import com.acjkj.weixinutil.WeixinMpServiceConfig;
@Deprecated
public class DeployUtil {
	public static int batchSize = 100;
	private static Logger logger = Logger.getLogger(DeployUtil.class);
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public static String ServerUrl = "";
	public static void deployStore(final StoreMpInfo info) {
		final MyWxMpInMemoryConfigStorage config = new MyWxMpInMemoryConfigStorage();
		config.setAppId(info.getAppId());
		config.setSecret(info.getAppSecret());
		config.setToken(info.getToken());
		config.setAccountStoreId(info.getOrgId());
		WxMpService wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(config);
		WxMpMessageRouter wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
//		final String appId = info.getAppId();

//		
//		WxMpMessageHandler zxHandler = new WxMpMessageHandler() {
//			@Override
//			public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
//					Map<String, Object> context, WxMpService wxMpService,
//					WxSessionManager sessionManager) throws WxErrorException {
//				WxMpXmlOutNewsMessage m = null;
//				String openID = wxMessage.getFromUserName();
//					WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
//					item.setDescription(" ");
//					item.setTitle(" ");
//					item.setUrl("http://" + ServerUrl + "/mp/" + info.getAppId() + "/clickGetUserInfo/"+ openID + ".do");
//					m = WxMpXmlOutMessage.NEWS().fromUser(info.getAppId()).toUser(openID).addArticle(item).build();
//				return m;
//			}
//
//		};
//
//		// router
//		wxMpMessageRouter
//				.rule().eventKey(info.getAppId() + "_zixun").async(false)
//				.handler(zxHandler).end()
//				.rule().eventKey(info.getAppId() + "_zxts").async(false)
//				.async(false).end()
//				;

		// serviceMap
		synchronized (MpServiceFactory.serviceMap) {
			MpServiceFactory.serviceMap.put(info.getAppId(),new WeixinMpServiceConfig(config, wxMpService,wxMpMessageRouter));
		}

	}
	
	
}
