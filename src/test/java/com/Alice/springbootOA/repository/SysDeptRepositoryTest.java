package com.Alice.springbootOA.repository;

import com.Alice.springbootOA.pojo.SysDept;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * create by Alice
 * 2018/12/23  22:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysDeptRepositoryTest {

    @Autowired
    private SysDeptRepository sysDeptRepository;

    @Test
    public void findOne(){
        SysDept result = sysDeptRepository.findOne(4);
        Assert.assertNotNull(result);
    }

    @Test
    public void save(){
        SysDept dept = SysDept.builder().name("PHP后端开发")
                .parentId(2)
                .level("1")
                .seq(1)
                .remark("test")
                .operateIp("127.0.0.1")
                .operator("system")
                .operateTime(new Date()).build();

        sysDeptRepository.save(dept);

    }

    @Test
    public void update(){
        /*SysDept dept = sysDeptRepository.findOne(15);
        dept.setName("java后端开发");
        SysDept save = sysDeptRepository.save(dept);
        System.out.println(save);*/
        System.out.println(CollectionUtils.class.getProtectionDomain().getCodeSource().getLocation());

    }

    @Test
    public void testLike(){
        List<SysDept> sysDepts = sysDeptRepository.findByLevelLike(0 + ".%");
        Assert.assertEquals(4,sysDepts.size());
    }

    @Test
    public void testUpdateList(){
        SysDept s1 = sysDeptRepository.findOne(15);
        s1.setRemark("test list1");
        SysDept s2 = sysDeptRepository.findOne(16);
        s2.setRemark("test list2");
        List<SysDept> list = Arrays.asList(s1,s2);
        sysDeptRepository.save(list);
    }

    @Test
    public void testCount(){
       /* Integer result = sysDeptRepository.countByIdAndNameAndParentId(1,"技术部", 0);
        Integer result2 = sysDeptRepository.countByNameAndParentId("技术部", 0);
        Assert.assertEquals(1,result2.longValue());
        Assert.assertEquals(1,result.longValue());*/
        Integer result3 = sysDeptRepository.countByIdAndNameAndParentId(2, "后端开发", 1);
        System.out.println(result3);
        Assert.assertEquals(1,result3.longValue());

    }
}