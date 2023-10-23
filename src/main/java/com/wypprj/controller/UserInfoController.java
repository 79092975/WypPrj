package com.wypprj.controller;

import com.wypprj.entity.UserInfo;
import com.wypprj.exception.UserException;
import com.wypprj.result.Result;
import com.wypprj.result.ResultEnum;
import com.wypprj.service.UserInfoService;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;

/**
 * @Author: Administrator
 * @DATE: 2023/10/20 16:11
 * @Description: user info controller
 * @Version: 1.0
 */

@RestController
@RequestMapping("/user")
@Validated
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 返回所有有效的用户信息
     * @return 所有有效（state=1）的用户信息
     */
    @GetMapping("/list")
    public Result queryAllUser() {
        System.out.println("queryAllUser...");
        return Result.success(userInfoService.list());
    }

    /**
     * 返回指定id的用户信息
     * @param id 用户id
     * @return 返回指定id的用户信息，如果用户不存在，返回错误提示
     */
    @GetMapping("/query/{id}")
    public Result queryUserById(@PathVariable("id") @Min(value = 0,message = "id必须大于0") Long id) {
        System.out.println("queryUserById...");
        UserInfo userInfo = userInfoService.selectById(id);
        if (null == userInfo) {
            return Result.error(ResultEnum.FAIL.getCode(), "用户不存在");
        } else {
            return Result.success(userInfoService.selectById(id));
        }
    }

    /**
     * 修改用户信息
     * @param id 用户id
     * @param name 用户名称
     * @param age 用户年龄
     * @param email 用户邮箱
     * @param state 用户状态，0-无效，1-有效
     * @return 用户存在则返回修改后的信息，用户不存在返回错误提示
     */
//    @PutMapping("/put/{id}/{name}/{age}/{email}")
    @GetMapping("/put/{id}/{name}/{age}/{email}/{state}")
    public Result updateUser(@PathVariable @Min(value = 0,message = "id必须大于0") Long id,
                             @PathVariable @NotBlank(message = "name不能为空") String name,
                             @PathVariable @Min(value = 0,message = "age必须大于0") Integer age,
                             @PathVariable @Email(message = "邮箱格式不对") String email,
                             @PathVariable @Range(min = 0, max = 1, message = "state只能是0或1") Integer state) {
        System.out.println("updateUser...");
        try {
            return Result.success(userInfoService.updateUser(id, name, age, email, state));
        } catch (UserException e) {
            return Result.error(ResultEnum.ERROR.getCode(), e.getMessage());
        }
    }

    /**
     * 新增用户
     * @param name 用户名称
     * @param age 用户年龄
     * @param email 用户邮箱
     * @return 新增用户信息（state默认有效），同时向用户注册的邮箱发送一封欢迎邮件
     */
//    @PostMapping("/add/{name}/{age}/{email}")
    @GetMapping("/add/{name}/{age}/{email}")
    public Result addUser(@PathVariable @NotBlank(message = "name不能为空") String name,
                          @PathVariable @Min(value = 0,message = "age必须大于0") Integer age,
                          @PathVariable @Email(message = "邮箱格式不对") String email) {
        System.out.println("addUser...");
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setAge(age);
        userInfo.setEmail(email);
        return Result.success(userInfoService.addUser(userInfo));
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return 软删除（被删除用户的state置为0），返回被删除的用户信息，如果用户不存在，返回错误提示
     */
//    @DeleteMapping("/del/{id}")
    @GetMapping("/del/{id}")
    public Result delUser(@PathVariable @Min(value = 0,message = "id必须大于0") Long id) {

        try {
            return Result.success(userInfoService.delUser(id));
        } catch (UserException e) {
            return Result.error(ResultEnum.ERROR.getCode(), e.getMessage());
        }
    }
}
