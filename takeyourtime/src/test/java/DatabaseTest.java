/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author muisku
 */
public class DatabaseTest {
    
    Database test;
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ClassNotFoundException {
        test = new Database("jdbc:sqlite:todo.db");
        test.init();
    }
    
    @After
    public void tearDown() throws SQLException {
        Connection connection = test.getConnection();
        PreparedStatement stmt = connection.prepareStatement("DROP TABLE Task");
        
        stmt.executeUpdate();
        stmt.close();
        connection.close();
        
        connection = test.getConnection();
        stmt = connection.prepareStatement("DROP TABLE User");
        stmt.executeUpdate();
        stmt.close();
        connection.close();
                
    }
    @Test
    public void initreturn() {
        assertEquals(true, test.init());
    }

}
