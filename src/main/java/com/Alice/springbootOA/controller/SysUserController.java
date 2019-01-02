package com.Alice.springbootOA.controller;

import com.Alice.springbootOA.VO.ResultVO;
import com.Alice.springbootOA.exception.ValidException;
import com.Alice.springbootOA.form.UserForm;
import com.Alice.springbootOA.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by Alice
 * 2018/12/29  2:14 PM
 */
@Controller
@RequestMapping("/sys/user")
@Slf4j
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/save.json")
    @ResponseBody
    public ResultVO save(@Valid UserForm userForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【添加用户】 参数不正确, userForm={}",userForm);
            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
        }

        sysUserService.save(userForm);
        return ResultVO.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public ResultVO update(@Valid UserForm userForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【修改用户】 参数不正确, userForm={}",userForm);
            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
        }

        sysUserService.update(userForm);
        return ResultVO.success();
    }

}
