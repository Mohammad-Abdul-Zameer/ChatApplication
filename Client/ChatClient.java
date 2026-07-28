package Client;


import java.net.*;
import java.io.*;


public class ChatClient {


    Socket socket;

    BufferedReader reader;
    PrintWriter writer;



    public ChatClient(String username){


        try {


            socket = new Socket(
                    "localhost",
                    5000);


            reader = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));


            writer = new PrintWriter(
                    socket.getOutputStream(),
                    true);



            new Thread(new ReceiveMessage())
                    .start();



        }
        catch(Exception e){

            e.printStackTrace();

        }

    }



    public void sendMessage(String message){

        writer.println(message);

    }




    class ReceiveMessage implements Runnable{


        public void run(){

            try{

                String message;


                while((message =
                        reader.readLine()) != null){


                    ClientGUI.chatArea.append(
                            message + "\n");

                }


            }
            catch(Exception e){

                e.printStackTrace();

            }

        }

    }

}
