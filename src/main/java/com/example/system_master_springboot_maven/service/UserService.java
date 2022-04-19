package com.example.system_master_springboot_maven.service;

import com.example.system_master_springboot_maven.pojo.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User queryUserByName(String userName);
    List<User> queryUser();
    User login(User user);
}
