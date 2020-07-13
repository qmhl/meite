package com.mayikt.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.member.MemberRegisterService;

@FeignClient("app-mayikt-member")
public interface MemberRegisterServiceFeign extends MemberRegisterService {

}
