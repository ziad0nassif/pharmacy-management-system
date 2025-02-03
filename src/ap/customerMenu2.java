package ap;
import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;



public class customerMenu2 {
    static Connection con3;

    public customerMenu2(){
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Scanner sc = new Scanner(System.in);
    checkVAL checkVAL = new checkVAL();
    getID getID = new getID();
    LocalDate currentDate = LocalDate.now();
    updateQuantity updateQuantity = new updateQuantity();

    public boolean customerM2(String username , String pass){
        int c3,c5 ,c7;
        String c4 ,c9;
        int cid , mid, discoun =0;
        double invoice =0 ;
        

        System.out.println("1- Make an order");
        System.out.println("2- Delete an order");
        System.out.println("3- View medicines");
        System.out.println("4- View Orders history ");
        System.out.println("0- Exit");
        try{
            c3 = sc.nextInt();

        }catch(Exception e){System.out.println("Enter a valid number ,TRY AGAIN! ");
        sc.nextLine();
        return true;
    }


        if (c3 == 1) {
            do {
                System.out.println("1- Add medicine" );
                System.out.println("2- Calculate toal invoice");
                System.out.println("0- Exit");
                while (true) {
                    try{
                    c7 = sc.nextInt();
                    if (c7 >= 0 && c7 < 3) {
                        break;
                        
                    }else{System.out.println("Enter a valid number ,TRY AGAIN! ");}
                    } catch(Exception e){ System.out.println("Enter a valid number ,TRY AGAIN! ");
                    sc.nextLine();
                } 
                    
                }

                
                if (0 == c7) {
                    return true;
                    
                }else if (1 == c7) {
                    
                System.out.print("Write the name of medicine:  ");
                c4 = sc.next();
                System.out.print("How many?  ");
                try{
                c5 = sc.nextInt();} catch(Exception e){ System.out.println("Invalid Input"); return true;}
                if (checkVAL.checkDBname(c4, "medicine")) {
                    cid = getID.getCId(username, pass);
                    mid = getID.gtMId(c4);
                    String dateString = currentDate.toString(); // "YYYY-MM-DD"
                    if (updateQuantity.updateQ(mid, c5)) {

                        
                    


                    try{
                        Statement st12 = con3.createStatement();
                        String quary12 = "INSERT INTO orders ( cid , mid , dateP , quantity ) VALUES (" + cid + "," + mid + ",'" + dateString + "'," +c5 + ");";
                        st12.executeUpdate(quary12);
                        System.out.println("Medicine added successfully.");



                    }catch(Exception e){;}}else{System.out.println("No enough stock");}

                    try{
                        Statement st17 = con3.createStatement();
                        String query17 = "SELECT sellingPrice from medicine WHERE name ='" + c4 +"';";
                        ResultSet rs4 =st17.executeQuery(query17);
                        if (rs4.next()) {
                            invoice +=  (rs4.getDouble("sellingPrice"))* c5;

                            
                        } 
                
                        }catch(Exception e){;}
                    
                }else{System.out.println("No medicine with that name , TRY AGAIN");}
            }else if ( 2 ==c7){
                break;
                
            } 



                

                
            }while( c7 != 0);

            System.out.print("Do you hava a promo code? (y/n): ");
            c9 = sc.next();
            if (c9.equals("y")) {
                System.out.print("Write the code: ");
                String namec = sc.next();
                if (checkVAL.checkDBcode(namec, "promocode")){
                    try{
                        Statement s10 = con3.createStatement();
                        String query10 = "SELECT discount FROM promocode WHERE TRIM(code) = '"+namec +"';";
                        ResultSet rs10 = s10.executeQuery(query10);
                        if (rs10.next()) {
                            discoun = rs10.getInt("discount");


                            
                        }
                    }catch(Exception e){;}
                    invoice = invoice - (invoice * (discoun / 100.0));
                }else{System.out.println("Wrong Promocode!");}
                
                
            }


            System.out.println("Total cost of order  :  " + invoice);
            System.out.println("Order made successfully.");
            return true;
            
        } else if (c3 == 2) {

        
        } else if (c3 == 3) {
            displayStock displayStock = new displayStock();
            return true;


        
        } else if (c3 == 4) {
            cid = getID.getCId(username, pass);


            try {
                Statement st = con3.createStatement();
                String query = "SELECT * FROM orders WHERE cid = " + cid + ";";
                ResultSet rs = st.executeQuery(query);
            
                System.out.println("+-----+------+------------+----------+");
                System.out.println("| oid | mid  | dateP      | quantity |");
                System.out.println("+-----+------+------------+----------+");
            
                boolean hasOrders = false;
                while (rs.next()) {
                    hasOrders = true;
                    System.out.printf("| %-3d | %-4d | %-10s | %-8d |\n",
                            rs.getInt("oid"),
                            rs.getInt("mid"),
                            rs.getString("dateP"),
                            rs.getInt("quantity"));
                }
            
                if (!hasOrders) {
                    System.out.println("| No orders found for this user.      |");
                }
            
                System.out.println("+-----+------+------------+----------+");
            
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
            
        
        } else if (c3 == 0) {
            return false;
        
        }
    













        return false;
    }
    




}
