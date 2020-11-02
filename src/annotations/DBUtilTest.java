package annotations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ClassName:DBUtilTest
 * Package:annotations
 * Description:
 *
 * @Date:2020/9/7 10:25
 * @Author:xuan
 */
@DBConfig(url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC", user = "root", password = "xuan538110")
public class DBUtilTest {

        //声明Connection对象
        static Connection con;
        //驱动程序名
        static String driver = "com.mysql.jdbc.Driver";
        static{
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    public static Connection getConnection() throws SQLException, NoSuchMethodException, SecurityException {
        DBConfig config = DBUtilTest.class.getAnnotation(DBConfig.class);

        String url = config.url();
        String user = config.user();
        String password = config.password();

        return DriverManager.getConnection(url, user, password);
    }
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
        System.out.println(getConnection());
    }
    }

