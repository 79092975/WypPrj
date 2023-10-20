package com.wypprj.mapper;

import com.wypprj.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Administrator
 * @DATE: 2023/10/20 16:11
 * @Description: 用户信息数据操作映射
 * @Version: 1.0
 */
@Mapper
@Repository
public interface UserInfoMapper {
    /**
     * 返回所有有效的注册用户信息
     * @return 有效（state=1）的注册用户信息列表
     */
    List<UserInfo> selectAll();

    /**
     * 返回指定id的用户信息
     * @param id 用户id
     * @return 返回指定id的用户信息
     */
    UserInfo selectById(Long id);

    /**
     * 修改用户信息
     * @param id 用户id
     * @param name 用户名称
     * @param age 用户年龄
     * @param email 用户邮箱
     * @param state 用户状态，0-无效，1-有效
     */
    void updateUser(Long id, String name, Integer age, String email, Integer state);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return 用户id
     */
    Long addUser(UserInfo userInfo);

    /**
     * 删除用户（软删除）
     * @param id 用户id
     */
    void delUser(Long id);
}
