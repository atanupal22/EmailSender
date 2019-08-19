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
    
    String[][] input;
    @Before
    public void setUp() {
        input = new String[][]{
            {"rahul@test.com",  "rajat@test.com,rashmi@test.com,vinod@test.com"},
            {"vineet@test.com", "ajay@test.com,rajat@test.com,rahul@test.com"},
            {"Vinod@test.com", "rahul@test.com,nitin@test.com,vineet@test.com"}
        };
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Positive Test of friendChain method, of class EmailSender.
     */
    @Test
    public void testFriendChain_WithValidAddress() {
        System.out.println("friendChain with valid email address");
        String startingEmailAddress = "rahul@test.com";
        String emailAddress = "rahul@test.com";
        Set finalList = new HashSet();
        String[][] friendsArray = input;
        EmailSender instance = new EmailSender();
        int expResult = 7;
        Set result = instance.friendChain(startingEmailAddress, emailAddress, finalList, friendsArray);
        assertEquals(result.size(), expResult);

    }
    
    /**
     * Positive Test of friendChain method, of class EmailSender.
     */
    @Test
    public void testFriendChain_WithInvalidAddress() {
        System.out.println("friendChain with invalid email address");
        String startingEmailAddress = "rahul123@test.com";
        String emailAddress = "rahul123@test.com";
        Set finalList = new HashSet();
        String[][] friendsArray = input;
        EmailSender instance = new EmailSender();
        int expResult = 1;
        Set result = instance.friendChain(startingEmailAddress, emailAddress, finalList, friendsArray);
        assertEquals(result.size(), expResult);

    }

    /**
     * Positive Test of findIndexOf method, of class EmailSender.
     */
    @Test
    public void testFindIndexOf_WithValidAddress() {
        System.out.println("findIndexOf with valid email address");
        String emailAddress = "rahul@test.com";
        String[][] friendsArray = input;
        EmailSender instance = new EmailSender();
        int expResult = 0;
        int result = instance.findIndexOf(emailAddress, friendsArray);
        assertEquals(expResult, result);
       
    }
    
    /**
     * Negative Test of findIndexOf method, of class EmailSender.
     */
    @Test
    public void testFindIndexOf_WithInvalidAddress() {
        System.out.println("findIndexOf with invalid email address");
        String emailAddress = "rahul123@test.com";
        String[][] friendsArray = input;
        EmailSender instance = new EmailSender();
        int expResult = -1;
        int result = instance.findIndexOf(emailAddress, friendsArray);
        assertEquals(expResult, result);
       
    }
    
}
