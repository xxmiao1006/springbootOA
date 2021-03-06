package com.Alice.springbootOA.exception;

import com.Alice.springbootOA.enums.ResultEnum;

/**
 * 自定义表单参数校验异常
 * create by Alice
 * 2018/12/23  14:55
 */
public class ValidException extends RuntimeException {
    public ValidException() {
        super();
    }

    public ValidException(String message) {
        super(message);
    }

    public ValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidException(Throwable cause) {
        super(cause);
    }

    public ValidException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
    }

    protected ValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
