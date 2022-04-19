package com.example.system_master_springboot_maven.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.system_master_springboot_maven.pojo.DataStreams;
import com.example.system_master_springboot_maven.pojo.Iot10086;
import com.example.system_master_springboot_maven.service.RaspberryPiService;
import com.example.system_master_springboot_maven.utils.OneNetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RaspberrypiServiceImpl implements RaspberryPiService {

    @Override
    public JSONObject setDataStreams(DataStreams dataStreams) {
        return OneNetUtil.setDataStreams(dataStreams);
    }

    @Override
    public JSONObject getDataStreams(Iot10086 iot, String dataStream) {
        return OneNetUtil.getDataStreams(iot, dataStream);
    }
}