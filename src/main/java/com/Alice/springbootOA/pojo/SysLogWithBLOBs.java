package com.Alice.springbootOA.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 日记实体类（包括了text字段）
 * create by Alice
 * 2018/12/22  15:38
 */
@Data
@Entity
@Table(name = "sys_log")
public class SysLogWithBLOBs extends SysLog {
    /**旧值*/
    private String oldValue;

    /**新值*/
    private String newValue;
}
