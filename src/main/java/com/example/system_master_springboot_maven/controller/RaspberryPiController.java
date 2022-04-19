package com.example.system_master_springboot_maven.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.system_master_springboot_maven.pojo.DataStreams;
import com.example.system_master_springboot_maven.pojo.Iot10086;
import com.example.system_master_springboot_maven.service.RaspberryPiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "树莓派API接口")
@RestController
@RequestMapping(value = "/raspberry")
@Slf4j
public class RaspberryPiController {
    /**
     * 测试：
     * 790922175
     * crlYFewa6vBKP9fuk9w7WpHotSs=
     */
    @Autowired
    RaspberryPiService raspberryPiService;

    @PostMapping("/getData")
    @ApiOperation("获取OneNet所有数据流")
    public JSONObject getDataStreams(@RequestBody Iot10086 iot, HttpServletRequest request){
        System.out.println(iot);
        System.out.println(request.getHeader("token"));
        return raspberryPiService.getDataStreams(iot, null);
    }

    @PostMapping("/setData")
    @ApiOperation("上传数据流到OneNet")
    public JSONObject postDataStreams(@RequestBody DataStreams dataStreams) {
        System.out.println(dataStreams);
        return raspberryPiService.setDataStreams(dataStreams);
    }

    @PostMapping("/getData/{dataStream}")
    @ApiOperation("获取OneNet单一数据流")
    public JSONObject getDataStream(@RequestBody Iot10086 iot, @PathVariable String dataStream){
        return raspberryPiService.getDataStreams(iot, dataStream);
    }

}
