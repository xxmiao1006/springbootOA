package com.Alice.springbootOA.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * create by Alice
 * 2018/12/22  15:39
 */
@Data
@Entity
@Table(name = "sys_role")
public class SysRole {

    /**角色id*/
    @Id
    private Integer id;

    /**角色名称*/
    private String name;

    /**角色的类型，1：管理员角色，2：其他*/
    private Integer type;

    /**状态，1：可用，0：冻结*/
    private Integer status;

    /**备注*/
    private String remark;

    /**操作者*/
    private String operator;

    /**最后一次更新的时间*/
    private Date operateTime;

    /**最后一次更新者的ip地址*/
    private String operateIp;
}
