package ol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Test2
 * Package:ol
 * Description:
 *
 * @Date:2020/9/1 9:41
 * @Author:xuan
 */
public class Test2 {
    // 测试ping
    public static void pingIP() throws IOException {
        List<String> IPs=new ArrayList<>();
        List<String> DIPs=new ArrayList<>();
        String localIP = getIP();
        // 获取最后一个小数点前的内容
        String ip = localIP.substring(0, localIP.lastIndexOf('.') + 1);
        for(int i=0;i<256;i++) {
            Process p = Runtime.getRuntime().exec("ping "+ip+i);
            System.out.println("正在测试"+ip+i);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                if (line.length() != 0) {
                    sb.append(line + "\r\n");
                }
            }
            if((sb.indexOf("ms"))!=-1) {
                IPs.add(ip+i);
                System.out.println(ip+i+"可以连通");
            }else {
                DIPs.add(ip+i);
                System.out.println(ip+i+"不可以连通");
            }
        }
    }

    // 获取本机ip
    public static String getIP() throws UnknownHostException, UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.println("本机ip地址：" + ip);
        return ip;
    }

    public static void main(String[] args) throws IOException {
        pingIP();
    }
}