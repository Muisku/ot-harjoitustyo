/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import database.TaskDao;
import database.TaskInterfaceDao;
import database.UserDao;
import java.sql.SQLException;
import database.UserInterfaceDao;
import java.util.ArrayList;
import java.util.List;

/**
 * Sovelluslogiikasta vastaava luokka
 */
public class TimeService {

    private UserDao userdao;
    private TaskDao taskdao;
    private User logger;
    private Task task;

    public TimeService(TaskDao taskdao, UserDao userdao) {
        this.userdao = userdao;
        this.taskdao = taskdao;
    }

    /**
     * sisäänkirjautuminen
     *
     * @param name käyttäjätunnus
     *
     * @return true jos käyttäjätunnus on olemassa, muuten false
     */
    public boolean login(String name) throws SQLException {
        User user = (User) userdao.findOne(name);
        if (user == null) {
            return false;
        }
        logger = user;
        return true;
    }

    /**
     * Uuden todon lisääminen kirjautuneena olevalle käyttäjälle
     *
     * @param input luotavan tehtävän sisältö
     */
    public boolean createTask(String input) throws SQLException {

        Task task = new Task(input, logger);
        taskdao.saveOrUpdate(task);

        return true;
    }
     /**
     * Palauttaa käyttäjän tehtävät
     *
     *  
     */
    public List<Task> getTasks() throws SQLException {
        if (logger == null) {
            return new ArrayList<>();
        }
        return taskdao.findAll(logger.getUsername());
    }
     /**
     * Luo uuden käyttäjän
     *
     * @param username käyttäjätunnus
     * @param name käyttäjän nimi
     */
    public boolean createUser(String username, String name) throws SQLException {
        if (userdao.findOne(name) != null) {
            return false;
        }
        User user = new User(username, name);

        try {
            userdao.saveOrUpdate(user);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
     
    /**
     * Palauttaa nykyisen käyttäjän joka on kirjautunut
     *
     * 
     */
    public User getLoggedUser() {
        return logger;
    }
    
     /**
    * uloskirjautuminen
    */  
    public boolean logout() {
        logger = null;
        return true;
    }

}
