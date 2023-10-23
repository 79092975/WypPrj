package com.wypprj.entity;

import lombok.Data;

import javax.validation.constraints.*;
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
    @NotNull(message = "id不能为空")
    @Min(value = 0, message = "id必须大于0")
    private Long id;
    //用户姓名
    @NotBlank(message = "name不能为空")
    private String name;
    //用户年龄
    @NotNull(message = "age不能为空")
    @Min(value = 0, message = "age必须大于0")
    private Integer age;
    //用户邮箱
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不对")
    private String email;
    //用户状态，0-无效，1-有效
    @NotNull(message = "state不能为空")
    @Size(max = 1, min = 0, message = "state只能是0或1")
    private Integer state;
}
