package com.Alice.springbootOA.repository;

import com.Alice.springbootOA.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create by Alice
 * 2018/12/22  16:03
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    SysUser findByUsername(String username);

}
