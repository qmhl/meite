package com.mayikt.pay.strategy.impl;

import com.mayikt.pay.mapper.entity.PaymentChannelEntity;
import com.mayikt.pay.strategy.PayStrategy;
import com.mayikt.weixin.out.dto.PayMentTransacDTO;

public class XiaoPayStrategy implements PayStrategy {

	@Override
	public String toPayHtml(PaymentChannelEntity pymentChannel, PayMentTransacDTO payMentTransacDTO) {

		return "小米支付from表单提交";
	}
	//com.mayikt.pay.strategy.impl.XiaoPayStrategy

}
