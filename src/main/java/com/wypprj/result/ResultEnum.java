package com.wypprj.result;

/**
 * @Author: Administrator
 * @DATE: 2023/10/20 16:33
 * @Description: 返回结果信息枚举
 * @Version: 1.0
 */
public enum ResultEnum {
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    ERROR(-11, "异常");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
