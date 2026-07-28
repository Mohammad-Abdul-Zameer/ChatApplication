package Server;

import java.net.*;
import java.io.*;
import java.util.*;


public class ClientHandler implements Runnable {


    Socket socket;

    BufferedReader reader;
    PrintWriter writer;

    ArrayList<ClientHandler> clients;


    public ClientHandler(Socket socket,
                         ArrayList<ClientHandler> clients) {

        try {

            this.socket = socket;
            this.clients = clients;


            reader = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));


            writer = new PrintWriter(
                    socket.getOutputStream(), true);


        } catch(Exception e){
            e.printStackTrace();
        }
    }



    public void run(){

        try {

            String message;


            while((message = reader.readLine()) != null){

                System.out.println(message);

                String username = message.split(":")[0];
                MessageDAO.saveMessage(username,message);
                ChatServer.broadcastMessage(
                message,this);
            }


        } catch(Exception e){

            e.printStackTrace();

        }

    }



    public void sendMessage(String message){

        writer.println(message);

    }

}
