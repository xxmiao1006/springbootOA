package com.Alice.springbootOA.exception;

import com.Alice.springbootOA.enums.ResultEnum;

/**
 * 自定义权限异常
 * create by Alice
 * 2018/12/22  17:06
 */
public class PermissionException extends RuntimeException {

    public PermissionException() {
        super();
    }

    public PermissionException(String message) {
        super(message);
    }

    public PermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionException(Throwable cause) {
        super(cause);
    }

    public PermissionException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
    }

    protected PermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
