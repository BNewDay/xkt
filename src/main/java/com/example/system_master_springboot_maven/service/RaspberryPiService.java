package com.example.system_master_springboot_maven.service;

import com.alibaba.fastjson.JSONObject;
import com.example.system_master_springboot_maven.pojo.DataStreams;
import com.example.system_master_springboot_maven.pojo.Iot10086;
import com.example.system_master_springboot_maven.pojo.RaspberryPi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaspberryPiService {
    JSONObject setDataStreams(DataStreams dataStreams);
    JSONObject getDataStreams(Iot10086 iot, String dataStream);
}
