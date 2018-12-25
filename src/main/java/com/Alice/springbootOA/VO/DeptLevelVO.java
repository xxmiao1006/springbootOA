package com.Alice.springbootOA.VO;

import com.Alice.springbootOA.pojo.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * create by Alice
 * 2018/12/24  14:39
 */
@Getter
@Setter
@ToString
public class DeptLevelVO extends SysDept {

    private List<DeptLevelVO> deptList = new ArrayList<>();

    public static DeptLevelVO adapt(SysDept dept){
        DeptLevelVO deptLevelVO = new DeptLevelVO();
        BeanUtils.copyProperties(dept,deptLevelVO);
        return deptLevelVO;
    }

}
