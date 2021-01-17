package com.zf.test;

import com.zf.dao.UserDao;
import com.zf.dao.impl.UserDaoImpl;
import com.zf.pojo.User;
import org.junit.Test;

public class UserDaoImplTest {

    UserDao userDao = (UserDao) new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin","123456") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User( "admin", "123456", "男", 20, "18639832089")));
    }
}