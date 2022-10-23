package com.lytest.exer;

import java.sql.*;

/**
 * @author ly
 * @Date:2022/07/27/17:25
 * @Description:
 */
public class TestJDBC {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "123456";

    static {
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            //1、加载驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败！");
            e.printStackTrace();
        }
        try {
            //建立连接
            conn = DriverManager.getConnection(url, user, password);
            //3、获取数据库操作对象
            state = conn.createStatement();
            //4、执行sql语句
            String sql = "insert into userinfo values ('小白杨','1234','23','2')";
            //5、获取结果集
            int count = state.executeUpdate(sql);
            System.out.println(count == 1? "保存成功":"保存失败");
            System.out.println(count);
        } catch (SQLException e) {
            System.out.println("获取连接失败！");
            e.printStackTrace();
        }finally {
            //6、释放资源
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
//            String sql = "select * from userinfo";
//            rs = state.executeQuery(sql);
//            while (rs.next()){
//                System.out.println(rs.getString("name"));
//                System.out.println(rs.getString("password"));
//            }

    }

    public static void main(String[] args) {

    }
}
