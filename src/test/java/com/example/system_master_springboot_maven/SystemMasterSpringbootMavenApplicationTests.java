package com.example.system_master_springboot_maven;

import com.example.system_master_springboot_maven.dao.ManagerDao;
import com.example.system_master_springboot_maven.service.Impl.RaspberrypiServiceImpl;;
import com.example.system_master_springboot_maven.service.ManagerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class SystemMasterSpringbootMavenApplicationTests {

	@Autowired
	RaspberrypiServiceImpl raspberryPiService;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	ManagerService managerService;


}
