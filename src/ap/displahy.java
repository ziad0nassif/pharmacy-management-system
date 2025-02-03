package ap;

import java.sql.*;
public class displahy {

    
    public static void main(final String[] args) {
        int id , age ; 
        String name;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "");
            Statement st = con.createStatement();
            String quary1 = "SELECT id , name , age FROM data WHERE id = 6";
            String name1;
            int id1 ,age1;
            ResultSet rs =  st.executeQuery(quary1);
            while (rs.next()) {
                name1 = rs.getString("name");
                age1 = rs.getInt("age");
                id1 = rs.getInt("id");
                System.out.println(id1 + "  " + name1 + "  " + age1 + "  ");

                
            }
        } catch( Exception e) {
            System.out.println(e);
        }




    }
}