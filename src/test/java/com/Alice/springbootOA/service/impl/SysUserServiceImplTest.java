package com.Alice.springbootOA.service.impl;

import com.Alice.springbootOA.form.UserForm;
import com.Alice.springbootOA.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Alice
 * 2018/12/29  3:36 PM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserServiceImplTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void save() {
        UserForm userForm = new UserForm();
        userForm.setUsername("肖学杪");
        userForm.setTelephone("15797652051");
        userForm.setMail("1151856023@qq.com");
        userForm.setDeptId(1);
        userForm.setStatus(0);
        userForm.setRemark("test");

        sysUserService.save(userForm);

    }

    @Test
    public void update() {
        UserForm userForm = new UserForm();
        userForm.setId(7);
        userForm.setUsername("Alice");
        userForm.setTelephone("15797652051");
        userForm.setMail("1151856023@qq.com");
        userForm.setDeptId(1);
        userForm.setStatus(1);
        userForm.setRemark("test update");
        sysUserService.update(userForm);
    }
}