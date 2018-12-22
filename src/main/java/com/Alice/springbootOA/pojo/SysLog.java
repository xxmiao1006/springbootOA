package com.Alice.springbootOA.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 日记实体类（不包含text字段）
 * create by Alice
 * 2018/12/22  15:36
 */
@Data
@Entity
@Table(name = "sys_log")
public class SysLog {
    /**id*/
    @Id
    private Integer id;

    /**权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系*/
    private Integer type;

    /**基于type后指定的对象id，比如用户、权限、角色等表的主键*/
    private Integer targetId;

    /**操作者*/
    private String operator;

    /**最后一次更新的时间*/
    private Date operateTime;

    /**最后一次更新操作者的ip地址*/
    private String operateIp;

    /**当前是否复原过，0：没有，1：复原过*/
    private Integer status;
}
