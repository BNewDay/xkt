package com.example.system_master_springboot_maven.service;

import com.example.system_master_springboot_maven.pojo.RaspberryPi;
import com.example.system_master_springboot_maven.pojo.User;

import java.util.List;

public interface ManagerService {
    User addManager(User user);
    User removeManager(String u_userName);
    int removeUser(String u_userName);
    int removePi(String rasp_apiKey);
    int changeUserInfo(User user);
    int changePiInfo(RaspberryPi raspberryPi);
    List<User> showUser();
    List<RaspberryPi> showPi();
    User searchUser(String u_userName);
    RaspberryPi searchPi(String rasp_apiKey);
}
