package com.wypprj.result;

import lombok.Data;

/**
 * @Author: Administrator
 * @DATE: 2023/10/20 16:35
 * @Description: 返回结果信息封装
 * @Version: 1.0
 */
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result() {

    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg);
    }
}
