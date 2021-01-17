package com.zf.service.impl;


import com.zf.dao.UserDao;
import com.zf.pojo.User;
import com.zf.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new com.zf.dao.impl.UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        /**
         * 登录，只是需要查询数据库即可！
         */
        return userDao.queryUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {
            // 等于null,说明没查到，没查到表示可用
            return false;
        }
        return true;
    }

}
