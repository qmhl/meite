package com.mayikt.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mayikt.base.BaseApiService;
import com.mayikt.mapper.MapperUtils;
import com.mayikt.pay.mapper.PaymentChannelMapper;
import com.mayikt.pay.mapper.entity.PaymentChannelEntity;
import com.mayikt.pay.service.PaymentChannelService;
import com.mayikt.weixin.out.dto.PaymentChannelDTO;

@RestController
public class PaymentChannelServiceImpl extends BaseApiService<List<PaymentChannelDTO>>
		implements PaymentChannelService {
	@Autowired
	private PaymentChannelMapper paymentChannelMapper;

	@Override
	public List<PaymentChannelDTO> selectAll() {
		List<PaymentChannelEntity> paymentChanneList = paymentChannelMapper.selectAll();
		return MapperUtils.mapAsList(paymentChanneList, PaymentChannelDTO.class);
	}

}
