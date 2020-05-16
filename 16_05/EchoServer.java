package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;
            try {
                ServerSocket serverSocket = new ServerSocket(8189);
                System.out.println("Сервер запущен!");
                socket = serverSocket.accept();
                System.out.println("Клиент подключился!");
                in = new DataInputStream(socket.getInputStream());
                out=new DataOutputStream(socket.getOutputStream());
                while (true){
                    String str = in.readUTF();
                    System.out.println(str);
                    if (str.equals("exit")){
                        break;
                    }
                    out.writeUTF("Ответ сервера: "+str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try{
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                try{
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
    }
}
