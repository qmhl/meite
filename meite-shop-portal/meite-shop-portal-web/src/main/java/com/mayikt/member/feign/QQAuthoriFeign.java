package com.mayikt.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.member.QQAuthoriService;

@FeignClient("app-mayikt-member")
public interface QQAuthoriFeign extends QQAuthoriService {

}
