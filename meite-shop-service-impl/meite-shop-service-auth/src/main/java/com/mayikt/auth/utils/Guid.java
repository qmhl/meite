package com.mayikt.auth.utils;

import java.util.UUID;

import com.mayikt.core.utils.MD5Util;

/**
 * 
 * 
 * 
 * @description:
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
public class Guid {
	public String appKey;

	/**
	 * @description:随机获取key值
	 * @return
	 */
	public String guid() {
		UUID uuid = UUID.randomUUID();
		String key = uuid.toString();
		return key;
	}

	/**
	 * 这是其中一个url的参数，是GUID的，全球唯一标志符
	 * 
	 * @param product
	 * @return
	 */
	public String getAppId() {
		Guid g = new Guid();
		String guid = g.guid();
		appKey = guid;
		return appKey;
	}

	/**
	 * 根据md5加密 appid+key 实现MD5
	 * 
	 * @param product
	 * @return
	 */
	public String getAppScrect() {
		String mw = "key" + appKey;
		String app_sign = MD5Util.MD5(mw).toUpperCase();// 得到以后还要用MD5加密。
		return app_sign;
	}

}