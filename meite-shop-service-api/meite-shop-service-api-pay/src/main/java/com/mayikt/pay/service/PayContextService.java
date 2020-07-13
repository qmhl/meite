package com.mayikt.pay.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.base.BaseResponse;

/**
 * 
 * 
 * 
 * @description: 根据不同的渠道id(支付方式) 返回不同的支付提交表单
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
public interface PayContextService {
	@GetMapping("/toPayHtml")
	public BaseResponse<JSONObject> toPayHtml(@RequestParam("channelId") String channelId,
			@RequestParam("payToken") String payToken);

}
