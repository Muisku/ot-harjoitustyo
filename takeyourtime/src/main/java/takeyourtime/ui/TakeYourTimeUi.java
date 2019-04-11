
package takeyourtime.ui;

import java.sql.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class TakeYourTimeUi extends Application {
    
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
