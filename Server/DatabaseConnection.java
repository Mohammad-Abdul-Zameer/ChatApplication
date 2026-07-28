package Server;

import java.sql.*;


public class DatabaseConnection {


    private static final String URL =
            "jdbc:mysql://localhost:3306/chatapp";


    private static final String USER =
            "root";


    private static final String PASSWORD =
            "your_password";


    public static Connection getConnection()
    {

        Connection con=null;

        try{

            Class.forName(
              "com.mysql.cj.jdbc.Driver");


            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD);


        }
        catch(Exception e){

            e.printStackTrace();

        }


        return con;
    }

}
