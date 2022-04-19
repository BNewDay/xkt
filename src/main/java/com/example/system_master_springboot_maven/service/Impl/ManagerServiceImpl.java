package com.example.system_master_springboot_maven.service.Impl;

import com.example.system_master_springboot_maven.dao.ManagerDao;
import com.example.system_master_springboot_maven.pojo.RaspberryPi;
import com.example.system_master_springboot_maven.pojo.User;
import com.example.system_master_springboot_maven.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    public User addManager(User user) {
        User temp = managerDao.selectManagerByName(user.getU_userName());
        if (temp != null){
            log.warn("管理员已存在");
            return null;
        } else{
            int result = managerDao.insertManager(user);
            if (result != 0){
                log.info("管理员注册成功");
                return user;
            }else {
                log.warn("管理员注册失败");
                return null;
            }
        }
    }

    @Override
    public User removeManager(String u_userName) {
        User manager = managerDao.selectManagerByName(u_userName);
        int result = managerDao.deleteManager("m_userName");
        if (result == 0){
            log.warn("删除管理员失败");
        }else {
            log.info("删除管理员成功");
        }
        return manager;
    }

    @Override
    public int removeUser(String u_userName) {
        return 0;
    }

    @Override
    public int removePi(String rasp_apiKey) {
        return 0;
    }

    @Override
    public int changeUserInfo(User user) {
        return 0;
    }

    @Override
    public int changePiInfo(RaspberryPi raspberryPi) {
        return 0;
    }

    @Override
    public List<User> showUser() {
        return null;
    }

    @Override
    public List<RaspberryPi> showPi() {
        return null;
    }

    @Override
    public User searchUser(String u_userName) {
        return null;
    }

    @Override
    public RaspberryPi searchPi(String rasp_apiKey) {
        return null;
    }
}
