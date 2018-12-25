package com.Alice.springbootOA.service.impl;

import com.Alice.springbootOA.VO.DeptLevelVO;
import com.Alice.springbootOA.pojo.SysDept;
import com.Alice.springbootOA.repository.SysDeptRepository;
import com.Alice.springbootOA.service.SysTreeService;
import com.Alice.springbootOA.util.LevelUtil;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * create by Alice
 * 2018/12/24  14:49
 */
@Service
public class SysTreeServiceImpl implements SysTreeService {

    @Autowired
    private SysDeptRepository sysDeptRepository;


    /**
     * 得到部门层级树,最终将rootlistVo返回
     * @return
     */
    @Override
    public List<DeptLevelVO> deptTree() {
        //查询所有部门
        List<SysDept> deptList = sysDeptRepository.findAll();

        //创建部门VO的集合，并且将每个部门转换为部门VO存在voList中，
        List<DeptLevelVO> voList = new ArrayList<>();
        deptList.forEach(e->{
            DeptLevelVO deptLevelVO = DeptLevelVO.adapt(e);
            voList.add(deptLevelVO);
        });
        //将voList转化为树形集合返回
        return deptListToTree(voList);
    }

    public List<DeptLevelVO> deptListToTree(List<DeptLevelVO> deptLevelList){
        if(CollectionUtils.isEmpty(deptLevelList)){
            return new ArrayList<>();
        }

        //level ->[dept1,dept2]  Multimap实际上就是一个map<String,List<Object>>
        Multimap<String,DeptLevelVO> levelDeptMap = ArrayListMultimap.create();

        List<DeptLevelVO> rootList = Lists.newArrayList();

        deptLevelList.forEach(e->{
            levelDeptMap.put(e.getLevel(),e);
            if(LevelUtil.ROOT.equals(e.getLevel())){
                rootList.add(e);
            }
        });

        //按照seq的顺序将rootList排序
        Collections.sort(rootList,(e1,e2)->e1.getSeq()-e2.getSeq());

        //递归生成树
        transformDeptTree(rootList,LevelUtil.ROOT,levelDeptMap);
        return rootList;
    }

    // level:0, 0, all 0->0.1,0.2
    // level:0.1
    // level:0.2
    private void transformDeptTree(List<DeptLevelVO> rootList, String level, Multimap<String,DeptLevelVO> levelDeptMap){
        for (int i = 0; i < rootList.size(); i++) {
            //遍历该层的每个元素
            DeptLevelVO deptLevelVO = rootList.get(i);
            //处理当前层级的数据
            String nextlevel = LevelUtil.calculateLevel(level, deptLevelVO.getId());
            //处理下一层
            List<DeptLevelVO> tempDeptList = (List<DeptLevelVO>) levelDeptMap.get(nextlevel);
            if(CollectionUtils.isNotEmpty(tempDeptList)){
                //排序
                Collections.sort(tempDeptList,(e1,e2)->e1.getSeq()-e2.getSeq());
                //设置下一部门
                deptLevelVO.setDeptList(tempDeptList);
                //进入下一层处理
                transformDeptTree(tempDeptList,nextlevel,levelDeptMap);
            }

        }
    }
}
