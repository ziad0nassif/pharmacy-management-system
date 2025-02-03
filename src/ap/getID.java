package ap;

import java.sql.*;
import java.util.Scanner;

public class getID {
    static Connection con5;

    public getID(){
           try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con5 = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public int getCId (String un , String pass ){
        try{
        Statement st = con5.createStatement();
        String query5 = "SELECT id FROM customer WHERE username = '" + un + "' AND password = '" + pass + "';";
        ResultSet rs = st.executeQuery(query5);
        if (rs.next()) {
            return rs.getInt("id");  // Get the ID from the result set
        }        
    }catch(Exception e) {;}
    return 0;

    }

    public int gtMId (String name  ){
        try{
        Statement st = con5.createStatement();
        String query6 = "SELECT id FROM medicine WHERE name = '" + name + "';";
        ResultSet rs = st.executeQuery(query6);
        if (rs.next()) {
            return rs.getInt("id");  // Get the ID from the result set
        }        
    }catch(Exception e) {;}
    return 0;

    }
}
