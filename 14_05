import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import static java.net.Proxy.Type.HTTP;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fin= new FileInputStream("C:/java/ip.txt");
            FileOutputStream fos=new FileOutputStream("C:/java/good_ip.txt");
            int i;
            String proxy = "";
            while ((i=fin.read())!= -1){
                proxy += (char)i;
            }
            String[] proxyArr = proxy.split("\n");
            for (i=0; i<proxyArr.length; i++){
                String ip = proxyArr[i].split("\t")[0];
                int port = Integer.parseInt(proxyArr[i].split("\t")[1].trim());
                System.out.print("Проверяю: "+ip+":"+port);
                if (checkProxy(ip,port)){
                    System.out.println(" - работает");
                    byte[] buffer = (ip+":"+port+"\n").getBytes();
                    fos.write(buffer, 0, buffer.length);
                }else {System.out.println(" - не работает");}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Работа завершена!");
    }

    static boolean checkProxy(String ip,int port){
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
                return true;
        }catch (IOException e) {
            return false;
        }
        return false;
    }
}
