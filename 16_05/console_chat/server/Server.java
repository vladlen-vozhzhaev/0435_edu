package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    static List<ClientHandler> clients = new ArrayList<>();
    public static void main(String[] args) {

        Socket socket = null;
        ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(8389);
                System.out.println("Сервер запущен!");
                while(true){
                    socket = serverSocket.accept();
                    System.out.println("Клиент подключился!");
                    clients.add(new ClientHandler(socket));
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
    static public void broadcastMsg(String msg){
        for(ClientHandler o: clients){
            o.sendMsg(msg);
        }
    }
}
