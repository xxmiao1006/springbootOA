package com.Alice.springbootOA.controller;

import com.Alice.springbootOA.VO.DeptLevelVO;
import com.Alice.springbootOA.VO.ResultVO;
import com.Alice.springbootOA.exception.ValidException;
import com.Alice.springbootOA.form.DeptForm;
import com.Alice.springbootOA.service.SysDeptService;
import com.Alice.springbootOA.service.SysTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * 部门
 * create by Alice
 * 2018/12/23  21:01
 */
@Controller
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysTreeService sysTreeService;

    @RequestMapping("/dept.page")
    public ModelAndView page(){
        return new ModelAndView("dept/dept");
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public ResultVO saveDept(@Valid DeptForm deptForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【添加部门】 参数不正确, deptForm={}",deptForm);
            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
        }

        sysDeptService.save(deptForm);
        return ResultVO.success();

    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public ResultVO tree(){
        List<DeptLevelVO> voList = sysTreeService.deptTree();
        return ResultVO.success(voList);
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public ResultVO update(@Valid DeptForm deptForm,BindingResult  bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【修改部门】 参数不正确, deptForm={}",deptForm);
            throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
        }
        sysDeptService.update(deptForm);
        return ResultVO.success();
    }

}
