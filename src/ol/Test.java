package ol;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ClassName:Test
 * Package:ol
 * Description:
 *
 * @Date:2020/9/1 9:37
 * @Author:xuan
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip =host.getHostAddress();
        System.out.println("本机ip地址：" + ip);
    }
}