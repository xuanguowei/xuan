package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ClassName:DButil
 * Package:jdbc
 * Description:
 *
 * @Date:2020/9/7 10:09
 * @Author:xuan
 */
public class DButil {
    //声明Connection对象
    static Connection con;
    //驱动程序名
    static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名
    static String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    //MySQL配置时的用户名
    static String user = "root";
    //MySQL配置时的密码
    static String password = "xuan538110";
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }
    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
