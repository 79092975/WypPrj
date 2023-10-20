package com.wypprj.service.impl;

import com.wypprj.entity.UserInfo;
import com.wypprj.exception.UserException;
import com.wypprj.mapper.UserInfoMapper;
import com.wypprj.service.MailService;
import com.wypprj.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Administrator
 * @DATE: 2023/10/19 17:35
 * @Description: 用户信息业务实现类
 * @Version: 1.0
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private MailService mailService;

    /**
     * 返回所有有效的注册用户信息
     * @return 所有有效（state=1）的注册用户信息
     */
    @Override
    public List<UserInfo> list() {
        return userInfoMapper.selectAll();
    }

    /**
     * 返回指定id的用户信息
     * @param id 用户id
     * @return 返回指定id的用户信息，如果用户不存在，返回错误提示
     */
    @Override
    public UserInfo selectById(Long id) {
        return userInfoMapper.selectById(id);
    }

    /**
     * 修改用户信息
     * @param id 用户id
     * @param name 用户名称
     * @param age 用户年龄
     * @param email 用户邮箱
     * @param state 用户状态，0-无效，1-有效
     * @return 用户存在则返回修改后的信息，用户不存在返回错误提示
     * @throws UserException
     */
    public UserInfo updateUser(Long id, String name, Integer age, String email, Integer state) throws UserException {
        UserInfo userInfo = userInfoMapper.selectById(id);
        if (userInfo == null) {
            throw new UserException("用户不存在！");
        }
        userInfoMapper.updateUser(id, name, age, email, state);
        return userInfoMapper.selectById(id);
    }

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return 新增用户信息（state默认有效），同时向用户注册的邮箱发送一封欢迎邮件
     */
    public UserInfo addUser(UserInfo userInfo) {
        userInfoMapper.addUser(userInfo);
        //发邮件
        UserInfo newUser = userInfoMapper.selectById(userInfo.getId());
        mailService.sendSimpleMail(newUser.getEmail(), "用户注册成功", "欢迎：" + newUser.getName() + "!");
        return newUser;
    }

    /**
     * 删除用户（软删除）
     * @param id 用户id
     * @return 软删除（被删除用户的state置为0），返回被删除的用户信息，如果用户不存在，返回错误提示
     */
    public UserInfo delUser(Long id) throws UserException {
        UserInfo userInfo = userInfoMapper.selectById(id);
        if (userInfo == null) {
            throw new UserException("用户不存在！");
        }
        userInfoMapper.delUser(id);
        return userInfoMapper.selectById(id);
    }
}
