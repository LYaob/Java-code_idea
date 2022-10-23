package com.lytest.java;

import java.sql.*;

/**
 * @author ly
 * @Date:2022/10/11/11:28
 * @Description:
 */
public class CreateJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
            //3、获取数据库操作对象
            state = conn.createStatement();
            //4、执行sql语句
            String sql = "insert into userinfo values ('jerry','1234','23','2')";
            //获取结果集
            int count = state.executeUpdate(sql);
            System.out.println(count == 1? "保存成功":"保存失败");
//            rs = state.executeQuery(sql);
//            while (rs.next()){
//                System.out.println(rs.getString("name"));
//                System.out.println(rs.getString("password"));
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (state != null){
                try {
                    state.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
