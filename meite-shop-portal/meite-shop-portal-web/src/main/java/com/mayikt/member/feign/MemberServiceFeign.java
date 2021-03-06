package com.mayikt.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.member.MemberService;

@FeignClient("app-mayikt-member")
public interface MemberServiceFeign extends MemberService {

}
