/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Task;
import domain.User;
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
public class TaskTest {
    
    Task test;
    User tester;
    
   @Before
   public void setUp() {
       
       test = new Task ("Tee laskarit", tester);
       tester = new User("Iina", "Iinanen");
       
   }
   
   @Test
   public void testName() {
      
       assertEquals("Tee laskarit", test.getTaskName());
       assertEquals("Iina", tester.getName());
   
   }
}
