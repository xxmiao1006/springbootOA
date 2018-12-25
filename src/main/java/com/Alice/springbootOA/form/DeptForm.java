package com.Alice.springbootOA.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * create by Alice
 * 2018/12/23  20:54
 */
@Data
public class DeptForm {

    private Integer id;

    @NotBlank
    @Length(max = 15,min = 2,message = "部门名称在2到15个字之间")
    private String name;

    private Integer parentId = 0;

    @NotNull(message = "展示顺序不能为空")
    private Integer seq;

    @Length(max = 150,message = "备注的长度在150个字之内")
    private String remark;

}
