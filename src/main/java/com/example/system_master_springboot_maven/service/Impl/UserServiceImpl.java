package com.example.system_master_springboot_maven.service.Impl;

import com.example.system_master_springboot_maven.dao.UserDao;
import com.example.system_master_springboot_maven.pojo.User;
import com.example.system_master_springboot_maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {
        List<User> list = userDao.selectAllUser();
        for (User u : list) {
            if(u.getU_userName().equals(user.getU_userName())){
                return null;
            }
        }
        int result = userDao.insertUser(user);
        if (result != 0){
            return user;
        }
        return null;
    }

    @Override
    public User queryUserByName(String userName) {
        /*User u = userDao.selectUserByName(user.getU_userName());
        if (u != null && user.getU_password().equals(u.getU_password())){
            return "Succeed";
        }
        return "密码错误或者账号不存在";*/

        return userDao.selectUserByName(userName);

    }

    @Override
    public List<User> queryUser() {
        return userDao.selectAllUser();
    }

    @Override
    public User login(User user){
        System.out.println(passwordEncoder.encode(user.getU_password()));
        User u = userDao.selectUserByName(user.getU_userName());
        if (u != null){
            if (u.getU_password().equals(user.getU_password())){
                return u;
            }
        }
        return null;
    }
}
