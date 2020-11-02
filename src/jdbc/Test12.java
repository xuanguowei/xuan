package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Test12
 * Package:jdbc
 * Description:
 *
 * @Date:2020/8/30 8:56
 * @Author:xuan
 */
public class Test12 {
    //获取第id条的信息
    public static Hero get(int id) {
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root", "xuan538110"); Statement s = c.createStatement();) {
            String sql = "select * from hero where id = " + id;
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat(3);
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                System.out.println("取出id=" + id + "的数据,它的name是:");
                System.out.println(hero.id + hero.name + hero.hp + hero.damage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    //增加数据
    public static void add(Hero h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "xuan538110");
                Statement s = c.createStatement();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {

            ps.setString(1, h.name);
            ps.setFloat(2, h.hp);
            ps.setInt(3, h.damage);
            ps.execute();
            System.out.println("新加一条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //删除数据
    public static void delete(Hero h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "delete from hero where id = ?";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                "root", "xuan538110"); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, h.id);
            ps.execute();
            System.out.println("删除id=" + h.id + "的数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //更新数据
    public static void update(Hero h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "update hero set name = ? , hp = ? , damage = ? where id = ?";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "xuan538110");
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, h.name);
            ps.setFloat(2, h.hp);
            ps.setInt(3, h.damage);
            ps.setInt(4, h.id);
            ps.execute();
            System.out.println("把名字改为" + h.name + "并且更新到数据库");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
    public static List<Hero> list() {
        List<Hero> list = new ArrayList<Hero>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC", "root", "xuan538110");
                Statement s = c.createStatement();
        ) {
            String sql = "select *from hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat(3);
                int damage = rs.getInt(4);
                hero.id = id;
                hero.name = name;
                hero.hp = (int) hp;
                hero.damage = damage;
                list.add(hero);

            }
            System.out.println("数据库一共有" + list.size() + "条数据");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        Hero h = new Hero();
        /*list();
        h.damage = 1111;
        add(h);
        list();
        h = get(12);*/
        h.name = "英雄20";
        h.id = 19;
        update(h);
        h = get(19);
        h.id = 18;
        delete(h);
        list();

    }
}
