package com.example.system_master_springboot_maven.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "raspberrypi")
public class RaspberryPi {
    private String rasp_deviceId;
    private Float rasp_temperature;
    private Float rasp_humidity;
    private Float rasp_pressure;
    private Double rasp_pitch;
    private Double rasp_roll;
    private Double rasp_yaw;
    private Double rasp_accX;
    private Double rasp_accY;
    private Double rasp_accZ;

    @Override
    public String toString() {
        return "RaspberryPi{" +
                "设备id=" + rasp_deviceId +
                ", 温度=" + rasp_temperature +
                ", 湿度=" + rasp_humidity +
                ", 压强=" + rasp_pressure +
                ", pitch=" + rasp_pitch +
                ", roll=" + rasp_roll +
                ", yaw=" + rasp_yaw +
                ", 加速度x=" + rasp_accX +
                ", 加速度y=" + rasp_accY +
                ", 加速度z=" + rasp_accZ +
                '}';
    }
}
