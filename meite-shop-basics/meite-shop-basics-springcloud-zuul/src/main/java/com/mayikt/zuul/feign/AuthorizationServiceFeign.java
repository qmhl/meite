package com.mayikt.zuul.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.mayikt.auth.service.api.AuthorizationService;

@FeignClient("app-mayikt-auth")
public interface AuthorizationServiceFeign extends AuthorizationService {

}
