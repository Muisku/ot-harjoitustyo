/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author muisku
 */
public class Task {
    
     int id;
     String taskName;
     public User user;
     
     public Task(int id, String taskName, User user) {
     
         this.id = id;
         this.taskName = taskName;
     
     }
     public Task(String taskName, User user) {
        
         this.taskName = taskName;
         this.user = user;
     
     }
     
     public Task(String taskName) {
        
         this.taskName = taskName;
      
     
     }
     
    public String getTaskName() {
        return taskName;
    }
 

    public User getUser() {
        return user;
    }

}
