package com.example.system_master_springboot_maven.dao;

import com.example.system_master_springboot_maven.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    @Insert("insert into User values(#{u_userName},#{u_nickName},#{u_password},#{u_WeChat},#{u_contactInformation},#{perms})")
    int insertUser(User user);
    @Delete("delete from User where u_userName=#{u_userName}")
    int deleteUser(String u_userName);
    /*修改密码*/
    @Update("update User set u_password=#{u_password} where u_userName = #{u_userName}")
    int updateUserPassword(User user);
    @Select("select * from User where u_userName=#{u_userName}")
    User selectUserByName(String u_userName);
    @Select("select * from User")
    List<User> selectAllUser();
}
