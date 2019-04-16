/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Task;
import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author muisku
 */
public class TaskDao implements TaskInterfaceDao<Task, String> {
    
    private Database database;
    private UserInterfaceDao<User, String> userdao;
    
    public TaskDao(Database database) {
        this.database = database;
    }



    @Override
    public Task saveOrUpdate(Task object) throws SQLException {
       Connection connection = database.getConnection();
       
       Task task = findOne(object.getUser().getUsername());
     
       PreparedStatement stmt = connection.prepareStatement("INSERT INTO Task"
               + " (user_username, taskName)"
               + " VALUES(?, ?)");
       
       stmt.setObject(1, object.getUser().getUsername());
       stmt.setString(2, object.getTaskName());
       
       stmt.executeUpdate();
       stmt.close();
       connection.close();
       
       return task;
       
    }
    
    @Override
    public Task findOne(String key) throws SQLException {
       Connection conn = database.getConnection();
       PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Task WHERE id = ?");
       stmt.setString(1, key);
       
       ResultSet rs = stmt.executeQuery();
       boolean hasOne = rs.next();
       if (!hasOne) {
           return null;
       }
       
       User user = userdao.findOne(rs.getString("user_username"));
       Task t = new Task(rs.getString("taskName"), user);
       
       stmt.close();
       rs.close();
       
       conn.close();
       
       return t;
    }
    
    @Override
    public void delete(String key) throws SQLException {
       Connection conn = database.getConnection();
       PreparedStatement stmt = conn.prepareStatement("DELETE FROM TASK WHERE id = ?");
       stmt.setString(1, key);
       stmt.executeUpdate();
       stmt.close();
       conn.close();
       
    }



    
}
