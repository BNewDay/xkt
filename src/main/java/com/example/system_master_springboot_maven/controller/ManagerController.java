package com.example.system_master_springboot_maven.controller;

import com.example.system_master_springboot_maven.pojo.User;
import com.example.system_master_springboot_maven.service.ManagerService;
import com.example.system_master_springboot_maven.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Api(tags = "管理员API接口")
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;
    @Autowired
    UserService userService;

    @PostMapping("/addManager")
    public String addManager(@RequestBody User user){
        if (user.getU_ident().equals("m")){
            managerService.addManager(user);
        }
        return "Test";
    }

    @GetMapping("/userList")
    @ApiOperation("用户表")
    public List<User> userList(){
        return userService.queryUser();
    }

}
