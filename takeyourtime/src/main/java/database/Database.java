/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    
    private String databaseAdress;
    
    public Database(String databaseAdress) throws ClassNotFoundException {
        this.databaseAdress = databaseAdress;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAdress);
    }
    
    public boolean init() {
        List<String>create_tables = createdbTables();
        
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            
            for (String table : create_tables) {
                st.executeUpdate(table);
            }
            
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            return false;
        }
        return true;
    }
    
    public List<String> createdbTables() {
        ArrayList<String> tables = new ArrayList<>();
        tables.add("CREATE TABLE IF NOT EXISTS User (username varchar (10) PRIMARY KEY, name varchar(20));");
        tables.add("CREATE TABLE IF NOT EXISTS Task (id Integer PRIMARY KEY, taskName varchar, user_username varchar, FOREIGN KEY (user_username) REFERENCES User(username));");
        
        return tables;
    }
    
}
