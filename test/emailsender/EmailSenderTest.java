/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailsender;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atanu
 */
public class EmailSenderTest {
    
    public EmailSenderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    String[][] friendsArray;
    EmailSender instance;
    @Before
    public void setUp() {
        friendsArray = EmailSender.input;
        instance = new EmailSender();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Positive Test of friendChain method, of class EmailSender.
     */
    @Test
    public void testFriendChain_WithValidAddress() {
        String emailAddress = "rahul@test.com";
        
        System.out.println("friendChain with valid email address :: " + emailAddress);
        
        int expResult = 7;
        Set result = instance.friendChain(emailAddress, friendsArray);
        assertEquals(result.size(), expResult);

    }
    
    /**
     * Positive Test of friendChain method, of class EmailSender.
     */
    @Test
    public void testFriendChain_WithInvalidAddress() {
        String emailAddress = "rahul123@test.com";
        
        System.out.println("friendChain with invalid email address :: " + emailAddress);

        int expResult = 1;
        Set result = instance.friendChain(emailAddress, friendsArray);
        assertEquals(result.size(), expResult);

    }

    /**
     * Positive Test of findIndexOf method, of class EmailSender.
     */
    @Test
    public void testFindIndexOf_WithValidAddress() {
        String emailAddress = "rahul@test.com";
        
        System.out.println("findIndexOf with valid email address :: " + emailAddress);
        
        int expResult = 0;
        int result = instance.findIndexOf(emailAddress, friendsArray);
        assertEquals(expResult, result);
       
    }
    
    /**
     * Negative Test of findIndexOf method, of class EmailSender.
     */
    @Test
    public void testFindIndexOf_WithInvalidAddress() {
        String emailAddress = "rahul123@test.com";
        
        System.out.println("friendChain with invalid email address :: " + emailAddress);

        int expResult = -1;
        int result = instance.findIndexOf(emailAddress, friendsArray);
        assertEquals(expResult, result);
       
    }
    
}
