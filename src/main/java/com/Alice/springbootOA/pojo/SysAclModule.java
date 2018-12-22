package com.Alice.springbootOA.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 权限模块实体类
 * create by Alice
 * 2018/12/22  15:27
 */
@Data
@Entity
@Table(name = "sys_acl_module")
public class SysAclModule {
    /**权限模块id*/
    @Id
    private Integer id;

    /**权限模块名称*/
    private String name;

    /**上级权限模块id*/
    private Integer parentId;

    /**权限模块层级*/
    private String level;

    /**权限模块在当前层级下的顺序，由小到大*/
    private Integer seq;

    /**状态，1：正常，0：冻结*/
    private Integer status;

    /**备注*/
    private String remark;

    /**操作者*/
    private String operator;

    /**最后一次操作时间*/
    private Date operateTime;

    /**最后一次更新操作者的ip地址*/
    private String operateIp;
}
