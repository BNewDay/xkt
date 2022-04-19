package com.example.system_master_springboot_maven.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置通过请求拦截。登陆成功后处理
 */
@Component("wawAuthenticationSuccessHandler")
public class WawAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * @param authentication   封装认证信息>>用户信息 请求ip之类的
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(authentication));
    }
}
