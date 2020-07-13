package com.mayikt.pay.strategy;

import com.mayikt.pay.mapper.entity.PaymentChannelEntity;
import com.mayikt.weixin.out.dto.PayMentTransacDTO;

/**
 * 
 * 
 * 
 * @description: 支付接口共同实现行为算法
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
public interface PayStrategy {

	/**
	 * 
	 * @param pymentChannel
	 *            渠道参数
	 * @param payMentTransacDTO
	 *            支付参数
	 * @return
	 */
	public String toPayHtml(PaymentChannelEntity pymentChannel, PayMentTransacDTO payMentTransacDTO);

}
