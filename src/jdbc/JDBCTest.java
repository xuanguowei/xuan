package jdbc;

import java.sql.*;

/**
 * ClassName:JDBCTest
 * Package:jdbc
 * Description:
 *
 * @Date:2020/8/24 10:50
 * @Author:xuan
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 admin

            c = DriverManager
                    .getConnection(
                            "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                            "root", "xuan538110");

            s = c.createStatement();
            String sql = "select * from hero";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int hp = rs.getInt(3);
                int damage = rs.getInt(4);
                System.out.println(id + name + hp + damage);
            }



        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if (s != null)

                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (c != null)
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }

    }
}