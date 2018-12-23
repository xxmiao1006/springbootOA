package com.Alice.springbootOA.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 测试表单检验
 * create by Alice
 * 2018/12/23  14:25
 */
@Data
public class TestForm {

    @NotBlank
    private String msg;

    @NotNull
    private Integer Id;

}
