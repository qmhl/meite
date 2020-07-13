package com.mayikt.member.mapper.entity;

import java.sql.Date;

import lombok.Data;

/**
 * 
 * 
 * 
 * @description: 用户实体类DO
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
@Data
public class UserDo {

	/**
	 * userid
	 */

	private Long userId;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 性别 0 男 1女
	 */
	private char sex;
	/**
	 * 年龄
	 */
	private Long age;
	/**
	 * 注册时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 *
	 */
	private Date updateTime;
	/**
	 * 账号是否可以用 1 正常 0冻结
	 */
	private char isAvalible;
	/**
	 * 用户头像
	 */
	private String picImg;
	/**
	 * 用户关联 QQ 开放ID
	 */
	private String qqOpenid;
	/**
	 * 用户关联 微信 开放ID
	 */
	private String wxOpenid;
}
