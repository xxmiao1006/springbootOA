package com.Alice.springbootOA.interceptor;

import com.Alice.springbootOA.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 自定义http请求拦截器
 * create by Alice
 * 2018/12/23  15:27
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();
        Map<String, String[]> map = request.getParameterMap();
        log.info("request start. url:{},parames:{}",url,JsonUtil.obj2String(map));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURI().toString();
        Map<String, String[]> map = request.getParameterMap();
        log.info("request finish. url:{},parames:{}",url,JsonUtil.obj2String(map));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        Map<String, String[]> map = request.getParameterMap();
        log.info("request complete. url:{},parames:{}",url,JsonUtil.obj2String(map));
    }
}
