package com.Alice.springbootOA.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户实体类
 * create by Alice
 * 2018/12/22  15:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sys_user")
public class SysUser {

    /**用户id*/
    @Id
    @GeneratedValue
    private Integer id;

    /**用户名称*/
    private String username;

    /**手机号*/
    private String telephone;

    /**邮箱*/
    private String mail;

    /**加密后的密码*/
    private String password;

    /**用户所在部门的id*/
    private Integer deptId;

    /**状态，1：正常，0：冻结状态，2：删除*/
    private Integer status;

    /**备注*/
    private String remark;

    /**操作者*/
    private String operator;

    /**最后一次更新时间*/
    private Date operateTime;

    /**最后一次更新者的ip地址*/
    private String operateIp;
}
