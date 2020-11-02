package jdbc;

import java.sql.*;

/**
 * ClassName:Test11
 * Package:jdbc
 * Description:
 *
 * @Date:2020/8/29 20:56
 * @Author:xuan
 */
public class Test11 {
    public static Hero get(int id) {
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC","root", "xuan538110");
             Statement s = c.createStatement();) {

            String sql = "select * from hero where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            // 因为id是唯一的，ResultSet最多只能有一条记录
            // 所以使用if代替while
            if (rs.next()) {
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat(3);
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hero;

    }

    public static void main(String[] args) {

        Hero h = get(17);
        System.out.println(h.hp);

    }
}
