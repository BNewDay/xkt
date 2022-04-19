package com.example.system_master_springboot_maven.config;

import com.example.system_master_springboot_maven.handler.WawAuthenticationFailHandler;
import com.example.system_master_springboot_maven.handler.WawAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 表单登陆security
 * 安全  = 认证 + 授权
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    WawAuthenticationFailHandler wawAuthenticationFailHandler;

    @Autowired
    WawAuthenticationSuccessHandler wawAuthenticationSuccessHandler;
    /**
     * 介绍
     *  springboot2.x引入的security版本是5.x的，这个版本需要提供一个PasswordEncoder实例，不然就会报错
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //以下五步是表单登录进行身份认证最简单的登陆环境
        http.formLogin() //表单登陆 1
                //.loginPage("/login.html") //指定登陆页面
                .loginPage("/login")
                .loginProcessingUrl("/auth")//登陆页面提交的页面 开始使用UsernamePasswordAuthenticationFilter过滤器处理请求
                .successHandler(wawAuthenticationSuccessHandler)
                .failureHandler(wawAuthenticationFailHandler)
                .and() //2
                .authorizeRequests() //下面的都是授权的配置 3
                .antMatchers("/login",
                        "login.html",
                        "/authentication/require",
                        "/auth").permitAll()//访问此地址就不需要进行身份认证了，防止重定向死循环
                .anyRequest() //任何请求 4
                .authenticated()//访问任何资源都需要身份认证 5
                .and()
                .cors();
    }
}
