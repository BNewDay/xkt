package com.example.system_master_springboot_maven.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DataStreams {
    private Iot10086 iot;
    private String dataStream;
    private String value;
}
