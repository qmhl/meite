package com.mayikt.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.member.MemberLoginService;

@FeignClient("app-mayikt-member")
public interface MemberLoginServiceFeign extends MemberLoginService {

}
