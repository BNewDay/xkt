package com.example.system_master_springboot_maven.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@ConfigurationProperties(prefix = "manager")
@ApiModel("Manager")
public class Manager {
    private String u_userName;
    private String u_password;
    private String u_WeChat;
    private String u_contactInformation;
    //身份
    private String u_ident;
}
