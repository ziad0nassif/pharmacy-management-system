package ap;

import java.sql.*;
import java.util.*;



public class store {


    private Connection con;

    public store() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        doctorMenu doctorMenu = new doctorMenu();
        customerMenu1acc customerMenu1acc = new customerMenu1acc();


        int u1=0 , u2=-4;


    while (true) {
            

            while (true) {
                
            
            try  {    
            System.out.println("Enter only one number:");
            System.out.println("1- Doctor" +"                 "+ "2- Customer  ");
            u1 = sc.nextInt();
            if (u1 ==1 || u1 ==2 ) {
                break;

            }else {
                System.out.println("Please enter  a valid Number.");
            }
            }catch(Exception e){
                System.out.println("");
                System.out.println("Wrong Input! ,Please enter  a valid Number.");
                sc.nextLine();
            }
        }

        
        if (1 == u1) {
            do {
                if (doctorMenu.mangerM()) {
                    
                }else {break;}
                
            }while(true);





            
            
        }else if(2 == u1){
            do {
                if (customerMenu1acc.customerM1()) {
                    
                }else {break;}
                
            }while(true);



        }

            
    }

        


       
    } 

}
