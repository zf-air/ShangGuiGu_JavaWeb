package com.zf.dao.impl;

import com.zf.dao.UserDao;
import com.zf.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `username`,`password`,`sex`,`age`,`phone` from user_info where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `username`,`password`,`sex`,`age`,`phone` from user_info where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user_info(`username`,`password`,`sex`,`age`,`phone`) values(?,?,?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getAge(), user.getPhone());
    }


}
