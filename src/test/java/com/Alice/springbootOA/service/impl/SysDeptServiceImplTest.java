package com.Alice.springbootOA.service.impl;

import com.Alice.springbootOA.form.DeptForm;
import com.Alice.springbootOA.service.SysDeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * create by Alice
 * 2018/12/23  22:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysDeptServiceImplTest {

    @Autowired
    private SysDeptService sysDeptService;

    @Test
    public void save() {
    }

    @Test
    public void update(){
        DeptForm deptForm = new DeptForm();
        deptForm.setId(15);
        deptForm.setName("java后端开发");
        deptForm.setSeq(1);
        deptForm.setParentId(2);
        deptForm.setRemark("test update");
        sysDeptService.update(deptForm);
    }
}