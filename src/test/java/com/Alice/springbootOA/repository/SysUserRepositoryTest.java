package com.Alice.springbootOA.repository;

import com.Alice.springbootOA.pojo.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * create by Alice
 * 2018/12/22  16:06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserRepositoryTest {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Test
    public void findByUsername() {
        SysUser result = sysUserRepository.findByUsername("Jimin");
        Assert.assertNotNull(result);
    }

    @Test
    public void save(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("Alice");
        sysUser.setMail("1151856023@qq.com");
        sysUser.setTelephone("15797652051");
        sysUser.setPassword("123456");
        sysUser.setDeptId(1);
        sysUser.setStatus(1);
        sysUser.setOperator("system");
        sysUser.setOperateIp("127.0.0.1");
        sysUser.setOperateTime(new Date());

        SysUser result = sysUserRepository.save(sysUser);
        Assert.assertNotNull(result);


    }

    @Test
    public void update(){
        SysUser sysUser = sysUserRepository.findOne(6);
        sysUser.setUsername("Aliceupdate");
        SysUser result = sysUserRepository.save(sysUser);
        Assert.assertEquals("Aliceupdate",result.getUsername());
    }
}