package com.example.system_master_springboot_maven.dao;

import com.example.system_master_springboot_maven.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerDao {
    @Insert("insert into user values(#{u_userName},#{u_password},#{u_WeChat},#{u_contactInformation},'m')")
    int insertManager(User user);
    @Delete("delete from user where u_userName = #{u_userName} and u_ident = 'm'")
    int deleteManager(String u_userName);
    @Update("update user set m_password = #{u_password} where u_userName = #{u_userName} and u_ident='m'")
    int updateManager(User user);
    @Select("select * from user where u_ident='m'")
    List<User> selectAllManager();
    @Select("select * from user where u_userName=#{u_userName} and u_ident='m'")
    User selectManagerByName(String u_userName);
}
