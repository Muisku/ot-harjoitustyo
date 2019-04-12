/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author muisku
 */
public class TaskDao implements Dao<Task, Integer> {
    
    private Database database;

    @Override
    public Task findOne(Integer key) throws SQLException {
       Connection conn = database.getConnection();
       PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Task WHERE id = ?");
       stmt.setInt(1, key);
       
       ResultSet rs = stmt.executeQuery();
       boolean hasOne = rs.next();
       if (!hasOne) {
           return null;
       }
       
       Task t = new Task(rs.getInt("id"), rs.getString("nimi"));
       
       stmt.close();
       rs.close();
       
       conn.close();
       
       return t;
       
    }

    @Override
    public List<Task> findAll() throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Task");
    }

    @Override
    public Task saveOrUpdate(Task object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws SQLException {
       Connection conn = database.getConnection();
       PreparedStatement stmt = conn.prepareStatement("DELETE FROM TASK WHERE id = ?");
       stmt.setInt(1, key);
       stmt.executeUpdate();
       stmt.close();
       conn.close();
       
    }
    
}
