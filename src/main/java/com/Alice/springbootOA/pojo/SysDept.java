package com.Alice.springbootOA.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 部门实体类
 * create by Alice
 * 2018/12/22  15:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sys_dept")
public class SysDept {
    /**部门id*/
    @Id
    @GeneratedValue
    private Integer id;

    /**部门名称*/
    private String name;

    /**上级部门id*/
    private Integer parentId;

    /**部门层级*/
    private String level;

    /**部门在当前层级下的顺序，由小到大*/
    private Integer seq;

    /**备注*/
    private String remark;

    /**操作者*/
    private String operator;

    /**最后一次操作时间*/
    private Date operateTime;

    /**最后一次更新操作者的ip地址*/
    private String operateIp;
}
