package com.Alice.springbootOA.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 角色-用户实体类
 * create by Alice
 * 2018/12/22  15:41
 */
@Data
@Entity
@Table(name = "sys_role_user")
public class SysRoleUser {
    /**ID*/
    @Id
    private Integer id;

    /**角色id*/
    private Integer roleId;

    /**用户id*/
    private Integer userId;

    /**操作者*/
    private String operator;

    /**最后一次更新的时间*/
    private Date operateTime;

    /**最后一次更新者的ip地址*/
    private String operateIp;
}
