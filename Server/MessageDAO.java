package Server;


import java.sql.*;


public class MessageDAO {


    public static void saveMessage(
            String username,
            String message)
    {


        try{


            Connection con =
            DatabaseConnection.getConnection();


            String sql =
            "INSERT INTO messages(username,message) VALUES(?,?)";


            PreparedStatement ps =
            con.prepareStatement(sql);


            ps.setString(1, username);
            ps.setString(2, message);


            ps.executeUpdate();


            con.close();


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }



    public static void showMessages()
    {


        try{


            Connection con =
            DatabaseConnection.getConnection();


            Statement st =
            con.createStatement();


            ResultSet rs =
            st.executeQuery(
            "SELECT * FROM messages");


            while(rs.next()){


                System.out.println(
                rs.getString("username")
                +" : "
                +rs.getString("message"));

            }


        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

}
