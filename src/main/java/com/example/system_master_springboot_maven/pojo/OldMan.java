package com.example.system_master_springboot_maven.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ApiModel(value = "OldMan")
public class OldMan {
    private Integer old_id;
    private String old_name;
    private String old_gender;
    private String old_birthday;
    private String old_addressProvince;
    private String old_addressCity;
    private String old_detailAddress;
    private String old_remarks;
    private String old_contactInformation;
}
