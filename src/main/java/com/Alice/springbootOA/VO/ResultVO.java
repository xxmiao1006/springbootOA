package com.Alice.springbootOA.VO;

import lombok.Data;

/**
 * http最外层返回对象 json格式
 * create by Alice
 * 2018/12/22  16:38
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}