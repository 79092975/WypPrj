package com.wypprj.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Administrator
 * @DATE: 2023/10/20 16:30
 * @Description: user info entity
 * @Version: 1.0
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    //用户id
    private Long id;
    //用户姓名
    private String name;
    //用户年龄
    private Integer age;
    //用户邮箱
    private String email;
    //用户状态，0-无效，1-有效
    private Integer state;
}
