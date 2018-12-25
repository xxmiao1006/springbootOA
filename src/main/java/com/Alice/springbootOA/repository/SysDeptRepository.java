package com.Alice.springbootOA.repository;

import com.Alice.springbootOA.pojo.SysDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * create by Alice
 * 2018/12/23  21:06
 */
public interface SysDeptRepository extends JpaRepository<SysDept,Integer> {

    List<SysDept> findByLevelLike(String level);

    Integer countByNameAndParentId(String name,Integer parentId);

    @Query(value = "SELECT COUNT(1) FROM sys_dept WHERE name =:name AND parent_id=:parentId AND id!=:id",nativeQuery = true)
    Integer countByIdAndNameAndParentId(@Param("id") Integer id, @Param("name") String name, @Param("parentId") Integer parentId);

}
