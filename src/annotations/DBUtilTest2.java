package annotations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ClassName:DBUtilTest2
 * Package:annotations
 * Description:
 *
 * @Date:2020/9/7 10:50
 * @Author:xuan
 */
public class DBUtilTest2 extends DBUtilTest {
    public static Connection getConnection2() throws SQLException, NoSuchMethodException, SecurityException {
        DBConfig config = DBUtilTest.class.getAnnotation(DBConfig.class);
        String url = config.url();
        String user = config.user();
        String password = config.password();

        //String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
        Connection c = getConnection2();
        System.out.println(c);
    }
}
