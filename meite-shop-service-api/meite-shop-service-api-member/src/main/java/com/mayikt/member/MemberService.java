package com.mayikt.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mayikt.base.BaseResponse;
import com.mayikt.member.input.dto.UserLoginInpDTO;
import com.mayikt.member.output.dto.UserOutDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * @description: 会员服务接口
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */

@Api(tags = "会员服务接口")
public interface MemberService {

	/**
	 * 根据手机号码查询是否已经存在,如果存在返回当前用户信息
	 * 
	 * @param mobile
	 * @return
	 */
	@ApiOperation(value = "根据手机号码查询是否已经存在")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "mobile", dataType = "String", required = true, value = "用户手机号码"), })
	@PostMapping("/existMobile")
	BaseResponse<UserOutDTO> existMobile(@RequestParam("mobile") String mobile);

	/**
	 * 根据token查询用户信息
	 * 
	 * @param userEntity
	 * @return
	 */
	@GetMapping("/getUserInfo")
	@ApiOperation(value = "/getUserInfo")
	BaseResponse<UserOutDTO> getInfo(@RequestParam("token") String token);

	/**
	 * SSO认证系统登陆接口
	 * 
	 * @param userLoginInpDTO
	 * @return
	 */
	@PostMapping("/ssoLogin")
	public BaseResponse<UserOutDTO> ssoLogin(@RequestBody UserLoginInpDTO userLoginInpDTO);

}
