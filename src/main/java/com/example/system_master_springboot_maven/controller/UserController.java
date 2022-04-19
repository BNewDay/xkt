package com.example.system_master_springboot_maven.controller;

import com.example.system_master_springboot_maven.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "用户API接口")
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    /*
    * 查看老人健康状况
    * 老人信息注册
    * 解绑
    * 修改用户名和密码
    * */

    @GetMapping({"/index","/",""})
    @ApiOperation("用户初始页面")
    public String userIndex(Model model){
        return "User";
    }

    @GetMapping("/queryPi")
    @ApiOperation("查看我的设备")
    @ResponseBody
    public String queryPi(Model model){
        return "查看设备";
    }

    @GetMapping("/queryOld")
    @ApiOperation("老人信息")
    @ResponseBody
    public String queryOld(Model model){
        return "老人信息";
    }

    @GetMapping("/myInfo")
    @ApiOperation("我的信息")
    @ResponseBody
    public String myInfo(Model model){
        return "我的信息";
    }
}
