package com.mayikt.pay.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.base.BaseResponse;
import com.mayikt.pay.feign.PayContextFeign;
import com.mayikt.pay.feign.PayMentTransacInfoFeign;
import com.mayikt.pay.feign.PaymentChannelFeign;
import com.mayikt.web.base.BaseWebController;
import com.mayikt.weixin.out.dto.PayMentTransacDTO;
import com.mayikt.weixin.out.dto.PaymentChannelDTO;

/**
 * 
 * 
 * 
 * @description: 支付网站
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
@Controller
public class PayController extends BaseWebController {
	@Autowired
	private PayMentTransacInfoFeign payMentTransacInfoFeign;
	@Autowired
	private PaymentChannelFeign paymentChannelFeign;
	@Autowired
	private PayContextFeign payContextFeign;

	@RequestMapping("/pay")
	public String pay(String payToken, Model model) {
		// 1.验证payToken参数
		if (StringUtils.isEmpty(payToken)) {
			setErrorMsg(model, "支付令牌不能为空!");
			return ERROR_500_FTL;
		}
		// 2.使用payToken查询支付信息
		BaseResponse<PayMentTransacDTO> tokenByPayMentTransac = payMentTransacInfoFeign.tokenByPayMentTransac(payToken);
		if (!isSuccess(tokenByPayMentTransac)) {
			setErrorMsg(model, tokenByPayMentTransac.getMsg());
			return ERROR_500_FTL;
		}
		// 3.查询支付信息
		PayMentTransacDTO data = tokenByPayMentTransac.getData();
		model.addAttribute("data", data);
		// 4.查询渠道信息
		List<PaymentChannelDTO> paymentChanneList = paymentChannelFeign.selectAll();
		model.addAttribute("paymentChanneList", paymentChanneList);
		model.addAttribute("payToken", payToken);
		return "index";
	}

	/**
	 * 
	 * @param payToken
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/payHtml")
	public void payHtml(String channelId, String payToken, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		BaseResponse<JSONObject> payHtmlData = payContextFeign.toPayHtml(channelId, payToken);
		if (isSuccess(payHtmlData)) {
			JSONObject data = payHtmlData.getData();
			String payHtml = data.getString("payHtml");
			response.getWriter().print(payHtml);
		}

	}

}
