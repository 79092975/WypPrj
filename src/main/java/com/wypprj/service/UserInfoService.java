package com.wypprj.service;

import com.wypprj.entity.UserInfo;
import com.wypprj.exception.UserException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Administrator
 * @DATE: 2023/10/19 16:35
 * @Description: 用户信息业务接口
 * @Version: 1.0
 */

@Service
public interface UserInfoService {
    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> list();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserInfo selectById(Long id);

    /**
     * 修改用户信息
     * @param id
     * @param name
     * @param age
     * @param email
     * @param state
     * @return
     */
    UserInfo updateUser(Long id, String name, Integer age, String email, Integer state) throws UserException;

    /**
     * 新增用户信息
     * @param userInfo
     * @return
     */
    UserInfo addUser(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    UserInfo delUser(Long id) throws UserException;

}
