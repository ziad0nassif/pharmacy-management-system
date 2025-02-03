package ap;

import java.sql.*;
import java.util.Scanner;

public class doctorMenu {

    static Connection con1;

    public doctorMenu() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Scanner sc = new Scanner(System.in);

    checkVAL checkDB = new checkVAL();
    String m_us, m_pass;
    int u2 = 0;
    String nam, barcod, categ, exp_date;
    double sp;
    int quan;

    public  boolean mangerM(){
       



        
        System.out.println("");
        System.out.print("Enter your username: ");
        m_us = sc.next();
        System.out.print("Enter your password: ");
        m_pass = sc.next();

        if (checkDB.checkDB(m_us, m_pass, "doctor")) {
    while (true) {
            
        
        while (true) {
                
            try{
            System.out.println("--------------------------------");
            System.out.println("");
            System.out.println("1- Add new medicine");
            System.out.println("2- Update medicine in the stock");
            System.out.println("3- Delete a medicine from stock");
            System.out.println("4- Make a promocode");
            System.out.println("5- View all the stock");
            System.out.println("0- for exit ");
            u2 = sc.nextInt();
            if (u2 >=0 && u2 < 6) {
                break;
                
            }else{System.out.println("Enter a valid number ,TRY AGAIN! ");}
            
        }catch(Exception e) {System.out.println("Enter a valid number ,TRY AGAIN! ");
                             sc.nextLine();

    }}

            if (1== u2) {
                
                while (true) {
                    
                try{
                System.out.print("Enter medicine Name: ");
                nam = sc.next();
                System.out.print("Enter medicine Barcode: ");
                barcod = sc.next();
                System.out.print("Enter medicine Category: ");
                categ = sc.next();
                System.out.print("Enter medicine selling price: ");
                sp = sc.nextDouble();
                System.out.print("Enter medicine quantity: ");
                quan = sc.nextInt();
                System.out.print("Enter medicine Expire Date (yyyy-mm-dd): ");
                exp_date = sc.next();
                break;
            }catch(Exception e){
                System.out.println("Enter Valid input");
                sc.nextLine();

            }}
            try{
            Statement st = con1.createStatement();


            String query1 = "INSERT INTO medicine (name, barcode, category, sellingPrice, quantity, expireDate) VALUES ('" 
            + nam + "', '" + barcod + "', '" + categ + "'," + sp + "," + quan + ",'" + exp_date + "')"; 
            st.executeUpdate(query1);
            }catch(Exception e){;}
                 continue;
            }else if (u2 ==2){
                System.out.println("Enter barcode of medicine");
                barcod = sc.next();
                try{
                    Statement st8 = con1.createStatement();
                    String query8 = "SELECT * FROM medicine WHERE barcode = '"+ barcod + "';";
                    ResultSet rs8 = st8.executeQuery(query8);
                    if (rs8.next()) {
                        System.out.printf("%-10d%-20s%-20s%-20s%-15.2f%-10d%-15s\n",
                        rs8.getInt(1), // ID
                        rs8.getString(2), // Name
                        rs8.getString(3), // Barcode
                        rs8.getString(4), // Category
                        rs8.getDouble(5), // Selling Price
                        rs8.getInt(6), // Quantity
                        rs8.getString(7)); // Expire Date
                        while (true) {
                    
                            try{
                            System.out.print("Enter medicine new Name");
                            nam = sc.next();
                            System.out.print("Enter medicine new Category");
                            categ = sc.next();
                            System.out.print("Enter medicine new selling price");
                            sp = sc.nextDouble();
                            System.out.print("Enter medicine new quantity");
                            quan = sc.nextInt();
                            System.out.print("Enter medicine new Expire Date (yyyy-mm-dd)");
                            exp_date = sc.next();
                            break;
                        }catch(Exception e){
                            System.out.println("Enter Valid input");
                            sc.nextLine();
            
                        }}
                        try{
                        Statement st9 = con1.createStatement();
            
            
                        String query1 = "UPDATE medicine set name ='" + nam + "' , barcode = '"  +barcod+ "' , category = '" + categ + "' , sellingPrice =  '" +sp + "' , quantity = '" +quan + "' , expireDate = '"+exp_date+"' WHERE barcode = '" + barcod+"';" ;
                        st8.executeUpdate(query1);
                        }catch(Exception e){;}
                             continue;
                        


  
  

                        
                    }else{
                        System.out.println("No medicine with that barcode");
                    }
                }catch(Exception e){;}
                

                


            }else if (3== u2 ){
                System.out.println("Enter barcode of medicine");
                barcod = sc.next();
                if ( checkDB.checkDB(barcod, "medicine")){
                try{
                Statement st2 = con1.createStatement();
                String query2 = "DELETE FROM medicine WHERE barcod = " +barcod +";";
                st2.executeUpdate(query2);
            }catch(Exception e){;}
                continue;
        }else {System.out.println("There is no medicine with this barcode");
                continue;
    }

            }else if ( 4== u2){
                String pc ;
                int numberUsage , disc; 
                while ( true){
                try {
                System.out.println("Enter a Promocode word ");
                pc = sc.next();
                System.out.println("Enter a Promocode times of useges ");
                numberUsage = sc.nextInt();
                System.out.println("Enter a Promocode discount in precentages (%) ");
                disc = sc.nextInt();

                break;
            }catch(Exception e){
                    System.out.println("Enter a valid input");
                    sc.nextLine();

                }}
            try{
                Statement st3 = con1.createStatement();
                String query3 = "INSERT INTO promocode (code , times , discount) VALUES ( ' " + pc +" ' ," + numberUsage +","+ disc+");";
                st3.executeUpdate(query3);
                 
            }catch(Exception e){;}
            continue;


            }else if(5==u2){
                displayStock displayStock = new displayStock();  // This will fetch and display the stock data
                continue;

            }else if ( 0 == u2){
                return false;
            }else {
                System.out.println("Enter a valid number!");
            }




            

        



         }
        }else{
            System.out.println("Wrong usernmae or password , TRY AGAIN!");
            return false;

            
        }        


    }

}
