package com.example.system_master_springboot_maven.dao;

import com.example.system_master_springboot_maven.pojo.RaspberryPi;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RaspberryPiDao {
    int deletePi(String rasp_apiKey);
    int updatePi(RaspberryPi raspberryPi);
    int insertPi(RaspberryPi raspberryPi);
    RaspberryPi selectPiByApiKey(String rasp_apiKey);
    List<RaspberryPi> selectAll();
}
