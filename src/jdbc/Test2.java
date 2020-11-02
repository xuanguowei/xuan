package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ClassName:Test2
 * Package:jdbc
 * Description:
 *
 * @Date:2020/8/24 21:16
 * @Author:xuan
 */
public class Test2 {
    public static void main(String[] args)
    {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "xuan538110";
        //遍历查询结果集
        try
        {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            //Statement statement = con.createStatement();
            //要执行的SQL语句
            //String sql = "select * from user";    //从建立的login数据库的login——message表单读取数据
            String sql = "insert into hero values(null,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "xgw");
            ps.setInt(2, 120);
            ps.setInt(3, 50);
            ps.executeUpdate();
            ps.close();
            //3.ResultSet类，用来存放获取的结果集！！
            //statement.executeUpdate(sql);
            //ResultSet rs = statement.executeQuery(sql);

            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");

            String name = null;
           /* while(rs.next())
            {
                //获取stuname这列数据
                name = rs.getString("username");
                System.out.println(name);
            }
            rs.close();*/
            con.close();
        }
        catch(ClassNotFoundException e)
        {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            //数据库连接失败异常处理
            e.printStackTrace();
        }
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}