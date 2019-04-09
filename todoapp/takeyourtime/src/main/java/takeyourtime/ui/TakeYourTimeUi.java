
package takeyourtime.ui;

import java.sql.*;

public class TakeYourTimeUi {
    
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:testi.db");
        
        PreparedStatement statement = connection.prepareStatement("SELECT 1");
        
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            System.out.println("Hei tietokanta!");
        } else {
            System.out.println("Tietokanta ei moikannut takaisin :C");
        }
    }
}
