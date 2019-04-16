/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import database.Database;
import database.TaskDao;
import database.UserDao;
import domain.TimeService;
import java.awt.TextArea;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author muisku
 */
public class TodoUi extends Application {

    private Scene createnewuserscene;
    private Scene loginscene;
    private Scene todoscene;
    private VBox todoNodes;
    private javafx.scene.control.Label menuLabel = new javafx.scene.control.Label();
    private TimeService timeservice;
    public Database database;

    @Override
    public void init() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));

        try {
            String thisDatabase = properties.getProperty("thisDatabase");
            database = new Database(thisDatabase);
        } catch (Exception ex) {
            System.out.println("Error");
        }
        

        database.init();

        TaskDao taskdao = new TaskDao(database);
        UserDao userdao = new UserDao(database);
        timeservice = new TimeService(taskdao, userdao);

    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Start!");
        
        TextField giveusername = new TextField();
        
        Button createnewuser = new Button("createuser");
        Button login = new Button("login");
        
        HBox components = new HBox();
        components.setSpacing(20);
        components.getChildren().addAll(giveusername, login, createnewuser);
        
        loginscene = new Scene(components);
        stage.setScene(loginscene);
        stage.show();
        
        // login button
        
        login.setOnAction(e -> {
            String username = giveusername.getText();
            
            try {
                if (timeservice.login(username)) {
                    stage.setScene(todoscene);
                } 
            } catch (SQLException ex) {
                System.out.println("Error with login");
            }
        });
        
        
         // createuser button action
         
         createnewuser.setOnAction(e -> {
             stage.setScene(createnewuserscene);
         });
         
         userCreateView(stage);
         
         createTodoView(stage);
        
    }
    
    public void userCreateView(Stage stage) {
        TextField givenewusername = new TextField();
        TextField givename = new TextField();
        Button createuser = new Button("createuser");
        
        HBox createusercomponents = new HBox();
        createusercomponents.setSpacing(20);
        createusercomponents.getChildren().addAll(givenewusername, givename, createuser);
        
        createnewuserscene = new Scene(createusercomponents);
        
        // createuser button action
        
        createuser.setOnAction(e -> {
            String username = givenewusername.getText();
            String name = givenewusername.getText();
            
            try {
                if (timeservice.createUser(username, name)) {
                    stage.setScene(loginscene);
                }
            } catch (SQLException ex) {
                System.out.println("Error creating new user");
            }
        });
        
    }
    
    public void createTodoView(Stage stage) {
        TextField todo = new TextField();
        Button createtodo = new Button("createtodo");
        HBox createtodocomponents = new HBox();
        createtodocomponents.setSpacing(20);
        
        createtodocomponents.getChildren().addAll(todo, createtodo);
        
        todoscene = new Scene(createtodocomponents);
        
        createtodo.setOnAction(e -> {
            String task = todo.getText();
            
            try {
                if (timeservice.createTask(task)) {
                System.out.println("Something went in");
            }
            } catch (SQLException ex) {
                System.out.println("Error adding task");
                Logger.getLogger(TodoUi.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }

    
    
    public static void main(String[] args) {
	launch(args);
    }

}
