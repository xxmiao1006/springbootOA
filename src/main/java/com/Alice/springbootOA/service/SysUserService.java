package com.Alice.springbootOA.service;

import com.Alice.springbootOA.form.UserForm;

/**
 * Created by Alice
 * 2018/12/29  2:33 PM
 */
public interface SysUserService {

    void save(UserForm userForm);

    void update(UserForm userForm);
}
