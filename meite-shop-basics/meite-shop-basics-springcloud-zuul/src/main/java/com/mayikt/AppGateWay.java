package com.mayikt;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * 
 * 
 * @description: 微服务网关入口
 * @author: 97后互联网架构师-余胜军
 * @contact: QQ644064779、微信yushengjun644 www.mayikt.com
 * @date: 2019年1月3日 下午3:03:17
 * @version V1.0
 * @Copyright 该项目“基于SpringCloud2.x构建微服务电商项目”由每特教育|蚂蚁课堂版权所有，未经过允许的情况下，
 *            私自分享视频和源码属于违法行为。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableSwagger2Doc
@MapperScan(basePackages = "com.mayikt.zuul")
// @EnableApolloConfig
@EnableFeignClients
public class AppGateWay {
	//
	// @ApolloConfig
	// private Config config;
	@Value("${mayikt.zuul.swagger.document}")
	private String document;

	public static void main(String[] args) {
		SpringApplication.run(AppGateWay.class, args);
	}

	// 添加文档来源
	@Component
	@Primary
	class DocumentationConfig implements SwaggerResourcesProvider {
		@Override
		public List<SwaggerResource> get() {
			return resources();
		}

		private List<SwaggerResource> resources() {
			// 从阿波罗平台获取配置文件
			// String swaDocJson =
			// config.getProperty("mayikt.zuul.swagger.document", null);
			JSONArray docJsonArray = JSONArray.parseArray(document);
			List resources = new ArrayList<>();
			// 遍历集合数组
			for (Object object : docJsonArray) {
				JSONObject jsonObject = (JSONObject) object;
				String name = jsonObject.getString("name");
				String location = jsonObject.getString("location");
				String version = jsonObject.getString("version");
				resources.add(swaggerResource(name, location, version));
			}
			return resources;
		}

		private SwaggerResource swaggerResource(String name, String location, String version) {
			SwaggerResource swaggerResource = new SwaggerResource();
			swaggerResource.setName(name);
			swaggerResource.setLocation(location);
			swaggerResource.setSwaggerVersion(version);
			return swaggerResource;
		}

	}
	// 微服务网关Swagger 如何集成阿波罗 实现动态添加微服务Swagger文档

	/**
	 * 大体思路分析：<br>
	 * 1.将swaggerResource封装程json数组格式、<br>
	 * 2.使用原生代码方式获取配置文件 3.写一个监听，监听文件是否发生变化，发生变化重新加载值 递归算法
	 * 4.mayikt.zuul.swagger.document=
	 * 
	 */

}
