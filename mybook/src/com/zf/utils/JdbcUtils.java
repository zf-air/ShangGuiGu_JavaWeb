package com.zf.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {

    private static DruidDataSource dataSource;

    /**
     * 获取数据库连接池中的连接
     *
     * @return 如果返回null, 说明获取连接失败<br />有值就是获取连接成功
     */
    public static Connection getConnection() {
// 1. DataSource的实例化
        @SuppressWarnings("resource")
        DruidDataSource dataSource = new DruidDataSource();

        // 2.设置获取连接的基本参数
        dataSource.setUsername("root");
        dataSource.setPassword("zhangfan789..");
        dataSource.setUrl("jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=utf8");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        // 3. 配置其他的参数
        // 一开始在连接池中放入8个连接
        dataSource.setInitialSize(8);

        // 设置连接的最大数量为10
        dataSource.setMaxActive(10);

        // 4.获取连接
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//		System.out.println(connection);
        return connection;
    }

    /**
     * 关闭连接，放回数据库连接池
     *
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}