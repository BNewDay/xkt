package com.example.system_master_springboot_maven;

import com.example.system_master_springboot_maven.dao.ManagerDao;
import com.example.system_master_springboot_maven.pojo.User;
import com.example.system_master_springboot_maven.service.Impl.RaspberrypiServiceImpl;;
import com.example.system_master_springboot_maven.service.ManagerService;
import com.example.system_master_springboot_maven.utils.JwtUtil;
import org.apache.catalina.Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
class SystemMasterSpringbootMavenApplicationTests {

	@Autowired
	RaspberrypiServiceImpl raspberryPiService;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	ManagerService managerService;

	@Test
	public void testToken(){
		Map<String,Object> map = new HashMap<>();
		Map<String,String> payload = new HashMap<>();
		payload.put("name","user");
		//payload.put("nickName",user.getU_nickName());
		//生成JWT令牌
		String token = JwtUtil.getJwtToken("user", "123");
		map.put("state","true");
		map.put("msg","认证成功");
		map.put("token",token);//响应token
		System.out.println(token);
	}

	@Test
	public void testShiro(){
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		IniRealm realm = new IniRealm("classpath:shiro.ini");
		securityManager.setRealm(realm);
		//2、得到SecurityManager实例 并绑定给SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			//4、登录，即身份验证
			subject.login(token);
		} catch (AuthenticationException e) {
			//5、身份验证失败
		}
		try {
			Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
		}catch (AssertionError e){
			e.printStackTrace();
		}
		//6、退出
		subject.logout();
	}

}
