package com.Alice.springbootOA.VO;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * http最外层返回对象 json格式
 * create by Alice
 * 2018/12/22  16:38
 */
@Data
public class ResultVO{

    /** 错误码. */
    private boolean ret;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private Object data;

    public ResultVO(boolean ret) {
        this.ret = ret;
    }

    public static ResultVO success(Object object, String msg) {
        ResultVO ResultVO = new ResultVO(true);
        ResultVO.data = object;
        ResultVO.msg = msg;
        return ResultVO;
    }

    public static ResultVO success(Object object) {
        ResultVO ResultVO = new ResultVO(true);
        ResultVO.data = object;
        return ResultVO;
    }

    public static ResultVO success() {
        return new ResultVO(true);
    }

    public static ResultVO fail(String msg) {
        ResultVO ResultVO = new ResultVO(false);
        ResultVO.msg = msg;
        return ResultVO;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("ret", ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }
}