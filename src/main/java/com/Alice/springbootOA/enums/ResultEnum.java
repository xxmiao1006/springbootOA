package com.Alice.springbootOA.enums;

import lombok.Getter;

/**
 * create by Alice
 * 2018/12/23  21:33
 */
@Getter
public enum ResultEnum {

    DEPT_NAME_REPET("部门名称重复"),
    DEPT_NOT_EXIST("部门不存在"),
    EMAIL_EXIST("邮箱已存在"),
    TELEPHONE_EXIST("电话号码已经存在"),
    USER_NOT_EXIST("用户不存在")
    ;


    private String message;

    ResultEnum(String message) {
        this.message = message;
    }
}
