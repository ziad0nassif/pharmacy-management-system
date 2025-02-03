package ap;

import java.sql.*;
import java.util.Scanner;

public class customerMenu1acc {
    static Connection con2;
    customerMenu2 customerMenu2 = new customerMenu2();
    checkVAL checkVAL = new checkVAL();


    public customerMenu1acc(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Scanner sc = new Scanner(System.in);

    public boolean customerM1(){
        int c1;
        String fn , ln ,un ,pass ;
        int age ;
        long pnum;


        System.out.println("1- Log in ");
        System.out.println("2- Sign up(don't have an account)");
        System.out.println("0- exit");
        while (true) {
            
        
        try{
            c1 = sc.nextInt();

            if (c1 >= 0 && c1 < 3) {
                break;
                
            }else{System.out.println("Enter a valid number ,TRY AGAIN! ");}
            


        }catch(Exception e){System.out.println("Enter a valid number ,TRY AGAIN! ");
        sc.nextLine();
    }}
        if (1== c1) {
            try{
            System.out.print("Enter your Username: ");
            un = sc.next();
            System.out.print("Enter your Password: ");
            pass = sc.next();}catch(Exception e){System.out.println("Wrong usernmae or password , TRY AGAIN!");
            return false;}
    
            if ( checkVAL.checkDB(un, pass, "customer")){
                do {
                    if (customerMenu2.customerM2(un, pass)) {
                        
                    }else {break;}
                    
                }while(true);
                return false;


            }else{System.out.println("Wrong usernmae or password , TRY AGAIN!");
        return false;}

            
        
        }else if ( 2 == c1){
            try{
            System.out.print("Enter your First name: ");
            fn =sc.next();
            System.out.print("Enter your Last name: ");
            ln = sc.next();
            System.out.print("Enter your Phone number: ");
            pnum = sc.nextLong();
            System.out.print("Enter your Age: ");
            age = sc.nextInt();
            System.out.print("Enter your Username: ");
            un = sc.next();
            System.out.print("Enter your Password: ");
            pass = sc.next();

            try{
                Statement st10 = con2.createStatement();
                String query10 = "INSERT INTO customer (fname , lname , phone , age , username ,password) VALUES ('"+fn +"' ,'"
                +ln + "' ," + pnum + " , " + age + " ,'" + un + "' ,'" +pass + "' );";
                st10.executeUpdate(query10);

            }catch(Exception e){;}
            System.out.println("Account created successfully");
            System.out.println("");
            do {
                if (customerMenu2.customerM2(un, pass)) {
                    
                }else {break;}
                
            }while(true);
            return false;

            







            


            }catch(Exception e){System.out.println("Enter valid input, Try Again!");
                                 sc.nextLine();}
            
         


        }else if ( 0 == c1 ){
            return false;
        }
        

        return false;
    }



}
