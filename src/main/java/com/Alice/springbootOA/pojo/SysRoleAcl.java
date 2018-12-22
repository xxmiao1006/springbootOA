package com.Alice.springbootOA.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 角色-权限实体类
 * create by Alice
 * 2018/12/22  15:40
 */
@Data
@Entity
@Table(name = "sys_role_acl")
public class SysRoleAcl {

    /**ID*/
    @Id
    private Integer id;

    /**角色id*/
    private Integer roleId;

    /**权限id*/
    private Integer aclId;

    /**操作者*/
    private String operator;

    /**最后一次更新的时间*/
    private Date operateTime;

    /**最后一次更新者的ip地址*/
    private String operateIp;
}
