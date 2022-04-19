package com.example.system_master_springboot_maven.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@RestController
public class BrowserSecurityController {

    //将当前请求缓存到session里
    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 当需要身份认证时跳转到这里
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/authentication/require",method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED) //未授权状态码
    public String requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //拿到引发跳转的请求
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(savedRequest != null){
            String targetUrl = savedRequest.getRedirectUrl();
            String fileUrl=new URL(targetUrl).getFile();

            if(StringUtils.endsWithIgnoreCase(targetUrl,".html") || fileUrl.equals("/")){
                //调转到登录页  》》这里登录页做成可配置的
                redirectStrategy.sendRedirect(request,response,"/login");
            }
        }
        return "访问资源需要登陆，请访问登陆页面";
    }

}
