package com.project.KwangJinProJect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    @Autowired
    KwangJinService kwangJinService;

    protected void configure(HttpSecurity http) throws Exception {
        // 인가 정책 설정
        http
                .authorizeRequests() // 요청에 대한 보안 검사 실행
                .anyRequest().authenticated(); // 어떠한 요청에도 인증을 받도록 설정

        // 인증 정책 설정
        http
                .formLogin(); // formLogin인증 방식을 사용하도록 설정
    }
}
