package com.example.system_master_springboot_maven.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.system_master_springboot_maven.pojo.User;
import com.example.system_master_springboot_maven.service.ManagerService;
import com.example.system_master_springboot_maven.service.UserService;
import com.example.system_master_springboot_maven.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "基础API")
@Controller
@Slf4j
public class BaseController {
    @Autowired
    UserService userService;
    @Autowired
    ManagerService managerService;
    @Autowired
    static User u1;
    
    
    //初始页面
    @GetMapping({"/","/index"})
    @ApiOperation("初始页面")
    public String toIndex(Model model){
        model.addAttribute("msg", "hello world");
        return "index";
    }

    @GetMapping("/login")
    @ApiOperation("跳转登录页面")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/auth")
    @ResponseBody
    @ApiOperation("登录验证")
    public Map toAuth(@RequestBody User user){
        //controller层接收数据，生成token，并响应
        System.out.println(user);
        //System.out.println(request.getHeader("authorization"));
        Map<String,Object> map = new HashMap<>();
        try{
            User userDB = userService.login(user);
            System.out.println(userDB);
            Map<String,String> payload = new HashMap<>();
            payload.put("name",userDB.getU_userName());
            payload.put("nickName",userDB.getU_nickName());
            //生成JWT令牌
            String token = JwtUtil.getJwtToken(userDB.getU_userName(),userDB.getU_nickName());
            map.put("state","true");
            map.put("msg","认证成功");
            map.put("token",token);//响应token
            u1 = user;
            System.out.println(token);
        } catch (Exception e) {
            map.put("state","false");
            map.put("msg","认证失败");
        }
        System.out.println(map);
        return map;
    }
    //注册
    @GetMapping("/register")
    @ApiOperation("注册页面")
    public String register(){
        return "register1";
    }

    @PostMapping("/re")
    @ApiOperation("注册提交")
    public String re(@RequestBody User user){
        System.out.println(user);
        return "Succeed";
    }

    //提交注册
    @ApiOperation("提交用户注册信息")
    @PostMapping("/UserRe")
    public String registerUser(@RequestBody User user, Model model){
        log.info("Register: " + user);
        //操作数据库
        User u = userService.addUser(user);
        if (u != null){
            //注册成功提示页面
            return "Succeed";
        }else {
            //注册失败页面
            model.addAttribute("msg", "注册失败");
            return "register1";
        }
    }

    @RequestMapping("/Test")
    @ResponseBody
    public Map t(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        String token = request.getHeader("token");
        System.out.println(token);
        boolean au = JwtUtil.checkToken(token);
        System.out.println(au);
        if (au){
            map.put("status","200");
            map.put("message","成功");
            map.put("vo", u1);
        }else {
            map.put("status","400");
            map.put("message","未授权");
        }
        return map;
    }

    @GetMapping("/Failure")
    public String f(){
        return "Failure";
    }
}
