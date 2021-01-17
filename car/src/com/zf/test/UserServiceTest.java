package com.zf.test;

import com.zf.pojo.User;
import com.zf.service.UserService;
import com.zf.service.impl.UserServiceImpl;
import org.junit.Test;
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User("bbj168", "666666", "man",21,"18639832089"));
        userService.registUser(new User( "abc168", "666666", "woman",21,"18639832089"));
    }

    @Test
    public void login() {
        System.out.println( userService.login("admin", "123456"));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admin")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}