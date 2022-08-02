package com.zfc.mebatis;

import com.zfc.mebatis.mapper.User;

import java.sql.*;

/**
 * 执行器
 *
 * @auther:zfc
 * @Date:2022-08-02 19:33
 **/
public class ZFcExecutor {

    public <T> T query(String sql, Object parameter) {
        Connection conn = null;
        Statement statement = null;
        User user = new User();
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.创建连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "123456");
            // 3.执行查询
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(String.format(sql, parameter));
            // 4.获取结果集
            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setPassword(result.getString("password"));
            }
            System.out.println(user);
            // 5.关闭连接
            result.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return (T) user;
    }
}
