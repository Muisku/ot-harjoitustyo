/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    private String databaseAdress;
    
    public Database(String databaseAdress) throws ClassNotFoundException {
        this.databaseAdress = databaseAdress;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAdress);
    }
    
}
