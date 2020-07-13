package com.mayikt.pay.job.job.handler;

import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.stereotype.Component;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 
 * 使用任务调度实现自动化补偿
 * 
 * @description:
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
@JobHandler(value = "payJobHandler")
@Component
@Slf4j
public class PayJobHandler extends IJobHandler {

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		log.info(">>>使用任务调度实现自动化对账");
		return SUCCESS;
	}

}
