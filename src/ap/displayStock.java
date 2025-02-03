package ap;

import java.sql.*;

public class displayStock {

 public displayStock(){
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "");
            Statement st5 = con.createStatement();
            String quary1 = "SELECT id , name , barcode, category ,sellingPrice , quantity , expireDate FROM medicine";
            ResultSet rs = st5.executeQuery(quary1);
            while (rs.next()) {
                // Print column headers once
                if (rs.isFirst()) {
                    System.out.printf("%-10s%-20s%-20s%-20s%-15s%-10s%-15s\n",
                                      "ID", "Name", "Barcode", "Category", "SellingPrice", "Quantity", "ExpireDate");
                }
                
                // Print row data
                System.out.printf("%-10d%-20s%-20s%-20s%-15.2f%-10d%-15s\n",
                                  rs.getInt(1), // ID
                                  rs.getString(2), // Name
                                  rs.getString(3), // Barcode
                                  rs.getString(4), // Category
                                  rs.getDouble(5), // Selling Price
                                  rs.getInt(6), // Quantity
                                  rs.getString(7)); // Expire Date
            }
            

        
        
        }catch(Exception e){System.out.println(e);;}
 }
}
