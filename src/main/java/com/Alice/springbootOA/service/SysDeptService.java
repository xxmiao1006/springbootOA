package com.Alice.springbootOA.service;

import com.Alice.springbootOA.form.DeptForm;
import com.Alice.springbootOA.pojo.SysDept;

/**
 * create by Alice
 * 2018/12/23  21:05
 */
public interface SysDeptService {

    void save(DeptForm deptForm);

    void update(DeptForm deptForm);

    void updateWithChild(SysDept before, SysDept after);
}
