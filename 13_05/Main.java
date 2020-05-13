/* Рабочий прокси 138.197.32.120:3128
Список прокси https://hidemy.name/ru/proxy-list/  */

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import static java.net.Proxy.Type.HTTP;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fin=new FileInputStream("C:/java/ip.txt");
            int i;
            String proxy = "";
            while ((i=fin.read())!= -1){
                proxy += (char)i;
            }
            String ip = proxy.split(":")[0];
            int port = Integer.parseInt(proxy.split(":")[1]);
            checkProxy(ip,port);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Работа завершена!");
    }

    static void checkProxy(String ip,int port){
        URLConnection connection = null;
        try {
            Proxy proxy = new Proxy(HTTP,new InetSocketAddress(ip, port));
            connection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            char[] buffer = new char[256];
            int rc;

            StringBuilder sb = new StringBuilder();

            while ((rc = reader.read(buffer)) != -1)
                sb.append(buffer, 0, rc);

            reader.close();
            if (sb.toString().equals("111"))
                System.out.println(ip+":"+port+" - РАБОТАЕТ!");
        }catch (IOException e) {
            System.out.println(ip+":"+port+" - Не работает!");
        }
    }
}
