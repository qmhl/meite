package com.mayikt.pay.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import com.mayikt.weixin.out.dto.PaymentChannelDTO;

public interface PaymentChannelService {
	/**
	 * 查询所有支付渠道
	 * 
	 * @return
	 */
	@GetMapping("/selectAll")
	public List<PaymentChannelDTO> selectAll();
}
