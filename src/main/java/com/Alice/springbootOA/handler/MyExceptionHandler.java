package com.Alice.springbootOA.handler;

import com.Alice.springbootOA.VO.ResultVO;
import com.Alice.springbootOA.exception.PermissionException;
import com.Alice.springbootOA.exception.ValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * create by Alice
 * 2018/12/23  13:59
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handlerPermissionException(HttpServletRequest request, Exception e){
        //拿到请求的url 从url判断是请求json数据还是请求页面
        String url = request.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "System error";
        //.json .page
        // 这里我们要求项目中所有请求json数据，都是用.json结尾
        if(url.endsWith(".json")){
            if(e instanceof PermissionException || e instanceof ValidException){
                ResultVO resultVO = ResultVO.fail(e.getMessage());
                mv = new ModelAndView("jsonView",resultVO.toMap());
            }else {
                log.error("unknow json exception,url"+url,e);
                ResultVO resultVO = ResultVO.fail(defaultMsg);
                mv = new ModelAndView("jsonView",resultVO.toMap());
            }
        }else if(url.endsWith(".page")){  // 这里我们要求项目中所有请求page页面，都是用.page结尾
            log.error("unknow page exception,url"+url,e);
            ResultVO resultVO = ResultVO.fail(defaultMsg);
            mv = new ModelAndView("exception",resultVO.toMap());
        }else {
            log.error("unknow exception,url"+url,e);
            ResultVO resultVO = ResultVO.fail(defaultMsg);
            mv = new ModelAndView("jsonView",resultVO.toMap());
        }

        return mv;

    }

}
