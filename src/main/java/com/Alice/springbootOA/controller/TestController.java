package com.Alice.springbootOA.controller;

import com.Alice.springbootOA.VO.ResultVO;
import com.Alice.springbootOA.exception.PermissionException;
import com.Alice.springbootOA.form.TestForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Alice
 * 2018/12/22  2:15 PM
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public ResultVO hello() {
        log.info("hello");
        throw new RuntimeException("test exception");
        //return ResultVO.success("hello,permission");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public ResultVO validate(@Valid TestForm testForm, BindingResult bindingResult) {
        log.info("validate");
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(e->log.info("{}-{}",e.getField(),e.getDefaultMessage()));
            //throw new ValidException(bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultVO.success("test Validate");


    }

    @RequestMapping("/test.page")
    @ResponseBody
    public ResultVO testpage() {
        log.info("hello");
        throw new PermissionException("test exception");
        //return ResultVO.success("hello,permission");
    }



}
