package com.mayikt.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.unionpay.acp.sdk.SDKConfig;

/**
 * 
 * 
 * 银联支付项目初始化
 * 
 * @description:
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
@Component
public class InitUnionPayProject implements ApplicationRunner {

	// springboot 项目启动的时候 执行该方法
	@Override
	public void run(ApplicationArguments args) throws Exception {
		SDKConfig.getConfig().loadPropertiesFromSrc();
	}
}
