/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeyourtime.domain;

public class Todo {
    
    private int taskid;
    private String taskcontent;
    private boolean done;
    private boolean taketime;
    private User user;
    
    public Todo(int taskid, String taskcontent, boolean done, boolean taketime, User user) {
        
        this.taskid = taskid;
        this.taskcontent = taskcontent;
        this.done = done;
        this.taketime = taketime;
        
    }
    public void setId(int id) {
        this.taskid = id;
    }
    public int getId() {
        return this.taskid;
    }
    public String getTaskContent() {
        return this.taskcontent;
    }
    public boolean getDone() {
        return this.done;
    }
    public boolean getTakeTime() {
        return this.taketime;
    }
    public User getUser() {
        return this.user;
    }
}
