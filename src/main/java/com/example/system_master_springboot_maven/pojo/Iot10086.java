package com.example.system_master_springboot_maven.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
/*
*
*
* */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Iot10086 {
    private String apiKey;
    private String device_id;
}
