/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class UserTest {
    
    @Test
    public void createUser() {
        User user = new User("Jaakko", "Jaakottaja");
        assertEquals("Jaakko", user.getName());
        assertEquals("Jaakottaja", user.getUsername());
    }

}
