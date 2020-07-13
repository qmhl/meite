package com.mayikt.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.base.BaseResponse;
import com.mayikt.member.input.dto.UserLoginInpDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * 
 * @description:用户登陆接口服务
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
@Api(tags = "用户登陆服务接口")
public interface MemberLoginService {
	/**
	 * 用户登陆接口
	 * 
	 * @param userEntity
	 * @return
	 */
	@PostMapping("/login")
	@ApiOperation(value = "会员用户登陆信息接口")
	BaseResponse<JSONObject> login(@RequestBody UserLoginInpDTO userLoginInpDTO);

}
