package Server;

import java.net.*;
import java.util.*;

public class ChatServer {

    static ArrayList<ClientHandler> clientList = new ArrayList<>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Chat Server Started...");
            MessageDAO.showMessages();
            System.out.println("Waiting for clients...");

            while(true) {

                Socket socket = serverSocket.accept();

                System.out.println("New Client Connected");

                ClientHandler client =
                        new ClientHandler(socket, clientList);

                clientList.add(client);

                Thread thread = new Thread(client);
                thread.start();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void broadcastMessage(String message,
                                        ClientHandler sender) {

        for(ClientHandler client : clientList) {

            if(client != sender) {
                client.sendMessage(message);
            }
        }
    }
}
