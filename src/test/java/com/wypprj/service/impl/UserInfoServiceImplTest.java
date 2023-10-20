package com.wypprj.service.impl;

import com.wypprj.entity.UserInfo;
import com.wypprj.exception.UserException;
import com.wypprj.service.UserInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

/**
 * @Author: Administrator
 * @DATE: 2023/10/20 20:22
 * @Description: userInfoServiceImpl测试类
 * @Version: 1.0
 */
@SpringBootTest
class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void list() {
        List<UserInfo> userInfoList = userInfoService.list();
        Assertions.assertEquals(2, userInfoList.size());
    }

    @Test
    void selectById() {
        UserInfo userInfo = userInfoService.selectById(1L);
        Assertions.assertEquals("zhangsan", userInfo.getName());
    }

    @Test
    @Transactional  //表示不污染数据库
    void updateUser() throws UserException {
        UserInfo userInfo = userInfoService.updateUser(1L, "zhangsan1111", 10, "79092975@qq.com", 1);
        Assertions.assertEquals("zhangsan1111", userInfo.getName());
    }

    @Test
    @Transactional  //表示不污染数据库
    void addUser() {
        UserInfo newUser = new UserInfo();
        newUser.setName("zhaoliu");
        newUser.setAge(40);
        newUser.setEmail("79092975@qq.com");
        UserInfo userInfo = userInfoService.addUser(newUser);
        Assertions.assertEquals("zhaoliu", userInfo.getName());
    }

    @Test
    @Transactional  //表示不污染数据库
    void delUser() throws UserException {
        UserInfo userInfo = userInfoService.delUser(2L);
        Assertions.assertEquals("lisi", userInfo.getName());
    }
}