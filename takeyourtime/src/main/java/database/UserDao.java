/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muisku
 */
public class UserDao implements UserInterfaceDao<User, String> {
    
     private Database database;

    public UserDao(Database database) {
        this.database = database;
    }

    @Override
    public User findOne(String key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE username = ?");
        stmt.setString(1, key);
        
        ResultSet rs = stmt.executeQuery();
        boolean findOne = rs.next();
       
        if (!findOne) {
            return null;
        }
        
        User user = new User(rs.getString("name"), rs.getString("username"));
        
        stmt.close();
        rs.close();
        conn.close();
        
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveOrUpdate(User object) throws SQLException {
       Connection connection = database.getConnection();
       
       PreparedStatement stmt = connection.prepareStatement("INSERT INTO User(username, name) VALUES(?, ?)");
       
       stmt.setString(1, object.getUsername());
       stmt.setString(1, object.getName());
       
       stmt.executeUpdate();
       stmt.close();
       return true;
    }

    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
