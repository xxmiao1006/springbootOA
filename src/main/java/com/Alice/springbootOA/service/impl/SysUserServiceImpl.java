package com.Alice.springbootOA.service.impl;

import com.Alice.springbootOA.enums.ResultEnum;
import com.Alice.springbootOA.exception.PermissionException;
import com.Alice.springbootOA.exception.ValidException;
import com.Alice.springbootOA.form.UserForm;
import com.Alice.springbootOA.pojo.SysUser;
import com.Alice.springbootOA.repository.SysUserRepository;
import com.Alice.springbootOA.service.SysUserService;
import com.Alice.springbootOA.util.MD5Util;
import com.Alice.springbootOA.util.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Alice
 * 2018/12/29  2:33 PM
 */
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public void save(UserForm userForm) {
        //校验邮箱是否已经存在
        if(checkEmailExist(userForm.getMail(),userForm.getId())){
            log.error("【添加用户】 Email重复, email={}",userForm.getMail());
            throw new ValidException(ResultEnum.EMAIL_EXIST);
        }

        //校验电话号码是否已经被占用
        if(checkTelephoneExist(userForm.getTelephone(),userForm.getId())){
            log.error("【添加用户】 telephone重复, telephone={}",userForm.getTelephone());
            throw new ValidException(ResultEnum.TELEPHONE_EXIST);
        }

        String password = PasswordUtil.randomPassword();
        //TODO
        password = "123456";
        String encryptedPassword = MD5Util.encrypt(password);
        SysUser user = SysUser.builder().username(userForm.getUsername()).telephone(userForm.getTelephone())
                .mail(userForm.getMail()).password(encryptedPassword).deptId(userForm.getDeptId())
                .status(userForm.getStatus()).remark(userForm.getRemark()).build();
        user.setOperator("system");//TODO
        user.setOperateIp("127.0.0.1");
        user.setOperateTime(new Date());

        //TODO sendEmailto user the password
        sysUserRepository.save(user);


    }

    @Override
    public void update(UserForm userForm) {
        //校验邮箱是否已经存在
        if(checkEmailExist(userForm.getMail(),userForm.getId())){
            log.error("【修改用户】 Email重复, email={}",userForm.getMail());
            throw new ValidException(ResultEnum.EMAIL_EXIST);
        }

        //校验电话号码是否已经被占用
        if(checkTelephoneExist(userForm.getTelephone(),userForm.getId())){
            log.error("【修改用户】 telephone重复, telephone={}",userForm.getTelephone());
            throw new ValidException(ResultEnum.TELEPHONE_EXIST);
        }

        SysUser befor = sysUserRepository.findOne(userForm.getId());
        if (befor == null) {
            log.error("【修改用户】 用户不存在, username={}",userForm.getUsername());
            throw new PermissionException(ResultEnum.USER_NOT_EXIST);
        }

        SysUser after = SysUser.builder().id(userForm.getId()).username(userForm.getUsername()).telephone(userForm.getTelephone())
                .mail(userForm.getMail()).password(befor.getPassword()).deptId(userForm.getDeptId())
                .status(userForm.getStatus()).remark(userForm.getRemark()).build();
        after.setOperator("system");//TODO
        after.setOperateIp("127.0.0.1");
        after.setOperateTime(new Date());
        sysUserRepository.save(after);
    }

    public boolean checkEmailExist(String mail,Integer id){
        //TODO
        return false;
    }

    public boolean checkTelephoneExist(String telephone,Integer id){
        return false;
    }
}
