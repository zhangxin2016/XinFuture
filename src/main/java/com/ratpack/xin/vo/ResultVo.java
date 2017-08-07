package com.ratpack.xin.vo;

import lombok.Data;

/**
 * Created by zhangx on 2017/8/7.
 */
@Data
public class ResultVo<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ResultVo<T> success(T data){
        ResultVo<T> result = new ResultVo<>();
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }
    public static <T> ResultVo<T> error(int code,String message){
        ResultVo<T> result = new ResultVo<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> ResultVo<T> error(int code,String message,T data){
        ResultVo<T> result = new ResultVo<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

}
