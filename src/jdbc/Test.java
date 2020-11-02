package jdbc;

import java.sql.*;

/**
 * ClassName:Test
 * Package:jdbc
 * Description:
 *
 * @Date:2020/8/24 16:24
 * @Author:xuan
 */
public class Test {
    public static void pageQuery(Statement s, int start, int count) {
        String querySql = String.format("select * from hero limit %d, %d", start, count);
        try {
            ResultSet rs = s.executeQuery(querySql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int hp = rs.getInt(3);
                int damage = rs.getInt(4);
                System.out.printf("id:%d, name:%s, hp:%d, damage:%d %n", id, name, hp, damage);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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

            // 查询hero表中一共有多少条记录
            String sql = "select count(*) from hero";
            ResultSet rs = s.executeQuery(sql);
            int total = 0;
            if (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("hero表中一共有" + total + "条记录");


            // 一页查询total_every_page条记录，一共可分为pages页
            int total_every_page = 5;
            int pages = (int) Math.ceil((double) total / (double) total_every_page);
            System.out.println("一共可分为" + pages + "页");
            for (int i = 0; i < pages; i++) {
                System.out.printf("查询第%d页结果：%n", i + 1);
                pageQuery(s, i * total_every_page, total_every_page);
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