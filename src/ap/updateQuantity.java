package ap;

import java.sql.*;
import java.util.Scanner;

public class updateQuantity {
    static Connection con3;
    public updateQuantity(){

    
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Scanner sc = new Scanner(System.in);

    int z=0;
    public boolean updateQ(int mid , int quan){
        try{
            Statement st = con3.createStatement();

            String query1 = "SELECT quantity FROM medicine WHERE id = " +mid + ";";
            ResultSet rs = st.executeQuery(query1);
            if (rs.next()) {
                z= rs.getInt("quantity");
                if (z  >= quan) {
                    String query2 = "UPDATE medicine SET quantity = " + (z - quan) + " WHERE id = " + mid + ";";
                    st.executeUpdate(query2);
                    return true;

                    
                }else{System.out.println("Donot hane enough stock");
                return false;
            }
                
            }

        }catch(Exception e){;}
                return false;


    }

}
