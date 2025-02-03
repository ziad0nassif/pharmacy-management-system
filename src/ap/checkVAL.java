package ap;

import java.sql.*;

public class checkVAL {
    private Connection con;

    public checkVAL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkDB(String username, String pass, String tableName) {
        String query = "SELECT * FROM " + tableName + " WHERE userName = ? AND password = ?";

        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, username);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();

            return rs.next(); // Returns true if a record is found
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // If an error occurs or no match is found
    }

    public boolean checkDB(String barcode,  String tableName) {
        String query = "SELECT * FROM " + tableName + " WHERE barcode = ? ";

        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, barcode);
            ResultSet rs = st.executeQuery();

            return rs.next(); // Returns true if a record is found
        } catch (SQLException e) {
        }
        
        return false; // If an error occurs or no match is found
    }
    public boolean checkDBname(String name,  String tableName) {
        String query = "SELECT * FROM " + tableName + " WHERE name = ? ";

        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();

            return rs.next(); // Returns true if a record is found
        } catch (SQLException e) {
        }
        
        return false; // If an error occurs or no match is found
    }
    public boolean checkDBcode(String name,  String tableName) {
        String query = "SELECT * FROM " + tableName + " WHERE TRIM(code) = ? ";

        try (PreparedStatement st = con.prepareStatement(query)) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();

            return rs.next(); // Returns true if a record is found
        } catch (SQLException e) {
        }
        
        return false; // If an error occurs or no match is found
    }

}
