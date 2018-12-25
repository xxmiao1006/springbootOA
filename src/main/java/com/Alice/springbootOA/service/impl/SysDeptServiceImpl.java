package com.Alice.springbootOA.service.impl;

import com.Alice.springbootOA.enums.ResultEnum;
import com.Alice.springbootOA.exception.PermissionException;
import com.Alice.springbootOA.exception.ValidException;
import com.Alice.springbootOA.form.DeptForm;
import com.Alice.springbootOA.pojo.SysDept;
import com.Alice.springbootOA.repository.SysDeptRepository;
import com.Alice.springbootOA.service.SysDeptService;
import com.Alice.springbootOA.util.LevelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * create by Alice
 * 2018/12/23  21:07
 */
@Service
@Transactional
@Slf4j
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptRepository sysDeptRepository;


    @Override
    public void save(DeptForm deptForm) {
        //检查该部门下是否有名字相同的部门，如果有抛出异常
        if(checkExist(deptForm.getParentId(),deptForm.getName(),deptForm.getId())){
            log.error("【添加部门】 部门名重复, deptName={}",deptForm.getName());
           throw new ValidException(ResultEnum.DEPT_NAME_REPET);
        }

        //创建部门对象
        SysDept dept = SysDept.builder().name(deptForm.getName()).parentId(deptForm.getParentId())
                .seq(deptForm.getSeq()).remark(deptForm.getRemark()).build();
        //获得父部门级别
        String paentLevel = getLevel(deptForm.getParentId());
        //计算自己的部门级别
        String level = LevelUtil.calculateLevel(paentLevel, deptForm.getParentId());
        dept.setLevel(level);
        dept.setOperator("system");//TODO
        dept.setOperateIp("127.0.0.1");
        dept.setOperateTime(new Date());
        sysDeptRepository.save(dept);
    }

    /**
     * 更新部门
     * @param deptForm
     */
    @Override
    public void update(DeptForm deptForm) {
        //检查该部门下是否有名字相同的部门，如果有抛出异常
        if(checkExist(deptForm.getParentId(),deptForm.getName(),deptForm.getId())){
            log.error("【更新部门】 部门名重复, deptName={}",deptForm.getName());
            throw new ValidException(ResultEnum.DEPT_NAME_REPET);
        }

        //通过传过来的id，从数据库中查询，并判断是否有查到要修改的部门
        SysDept before = sysDeptRepository.findOne(deptForm.getId());
        if (before == null) {
            log.error("【更新部门】 部门不存在, deptName={}",deptForm.getName());
            throw new PermissionException(ResultEnum.DEPT_NOT_EXIST);
        }

        //设置完要修改的属性
        SysDept after = SysDept.builder().id(deptForm.getId()).name(deptForm.getName()).parentId(deptForm.getParentId())
                .seq(deptForm.getSeq()).remark(deptForm.getRemark()).build();
        after.setLevel(LevelUtil.calculateLevel(getLevel(deptForm.getParentId()), deptForm.getParentId()));
        after.setOperator("system");//TODO
        after.setOperateIp("127.0.0.1");
        after.setOperateTime(new Date());
        //更新子部门level
        updateWithChild(before,after);
    }


    /**
     * 更新子树
     * @param before
     * @param after
     */
    @Override
    public void updateWithChild(SysDept before,SysDept after){
        String oldLevelPrefix = before.getLevel();
        String newLevelPrefix = after.getLevel();
        //更新后的level与旧的level不相同，需要重新更新子部门的level
        if(!oldLevelPrefix.equals(newLevelPrefix)){
            List<SysDept> sysDepts = sysDeptRepository.findByLevelLike(before.getLevel());
            if(CollectionUtils.isNotEmpty(sysDepts)){
                for (SysDept sysDept : sysDepts) {
                    String level = sysDept.getLevel();
                    if(level.indexOf(oldLevelPrefix) ==0 ){
                        level = newLevelPrefix+level.substring(oldLevelPrefix.length());
                        sysDept.setLevel(level);
                    }
                }
                sysDeptRepository.save(sysDepts);
            }
        }
        sysDeptRepository.save(after);
    }

    /**
     * 校验是否有相同的部门
     * @param parentId
     * @param deptName
     * @param deptId
     * @return
     */
    private boolean checkExist(Integer parentId, String deptName, Integer deptId){
        Integer result;
        if (deptId == null) {
            result = sysDeptRepository.countByNameAndParentId(deptName, parentId);
        }else {
            result = sysDeptRepository.countByIdAndNameAndParentId(deptId,deptName,parentId);
        }
        return result>0;
    }

    /**
     * 通过部门id获得该部门的level
     * @param deptId
     * @return
     */
    private String getLevel(Integer deptId){
        SysDept dept = sysDeptRepository.findOne(deptId);
        if (dept == null) {
            return null;
        }
        return dept.getLevel();
    }

}
