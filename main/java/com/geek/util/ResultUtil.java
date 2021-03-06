package com.geek.util;

/**
 * 结果处理工具类
 * @author yuanyang
 * @version 1.0
 */
public class ResultUtil {

    public static final Result SUCCESS_RESULT = new Result("1", "success", null);
    public static final Result FAIL_RESULT = new Result("0", "fail", null);
    public static final Result UNHANDED_RESULT = new Result("0", "未处理异常", null);

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public static Result successResult(Object o){
        Result result = new Result();
        result.setStatus("1");
        result.setMessage(SUCCESS);
        if (o != null){
            result.setData(o);
        }
        return result;
    }

    public static Result successPagedResult(Object o, int total) {
        Result result = new Result("1", SUCCESS, total);
        if(o != null) {
            result.setData(o);
        }
        return result;
    }

    public static Result failResult(Object o){
        Result result = new Result();
        result.setStatus("0");
        result.setMessage(FAIL);
        if (o != null){
            result.setData(o);
        }
        return result;
    }

}
