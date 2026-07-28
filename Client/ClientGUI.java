package Client;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ClientGUI {


    static JTextArea chatArea;

    JTextField messageField;

    JButton sendButton;


    ChatClient client;



    public ClientGUI(){


        JFrame frame =
                new JFrame("Java Chat Application");


        frame.setSize(500,500);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);



        chatArea = new JTextArea();

        chatArea.setEditable(false);



        JScrollPane scroll =
                new JScrollPane(chatArea);



        messageField =
                new JTextField();



        sendButton =
                new JButton("Send");



        JPanel bottom =
                new JPanel();


        bottom.setLayout(
                new BorderLayout());


        bottom.add(messageField,
                BorderLayout.CENTER);


        bottom.add(sendButton,
                BorderLayout.EAST);



        frame.add(scroll,
                BorderLayout.CENTER);


        frame.add(bottom,
                BorderLayout.SOUTH);



        frame.setVisible(true);



        client =
                new ChatClient("User");




        sendButton.addActionListener(
                new ActionListener(){


            public void actionPerformed(ActionEvent e){


                String message =
                        messageField.getText();



                if(!message.isEmpty()){


                    client.sendMessage(
                            "User : " + message);


                    chatArea.append(
                            "Me : " + message+"\n");


                    messageField.setText("");

                }

            }

        });


    }



    public static void main(String args[]){

        new ClientGUI();

    }

}
