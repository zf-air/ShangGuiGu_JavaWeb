package com.zf.test;

import com.zf.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils ()throws Exception{
        for(int i=0;i<100;i++){
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.closeResource(conn);
        }
    }
}
