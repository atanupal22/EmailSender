/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailsender;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author atanu
 */
public class EmailSender {
    
    static String[][] input = new String[][]{
            {"rahul@test.com",  "rajat@test.com,rashmi@test.com,vinod@test.com"},
            {"vineet@test.com", "ajay@test.com,rajat@test.com,rahul@test.com"},
            {"Vinod@test.com", "rahul@test.com,nitin@test.com,vineet@test.com"}
        };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        emailSender.sendMail("rahul123@test.com", "test message", input);
    }
    
    /**
     * To send email to a particular email
     * @param emailAddress - Email ID to whom the email is been sent to.
     * @param message - Message body of email id
     */
    public void sendMail(String emailAddress, String message){
        System.out.println("Sending mail to : \"" + emailAddress + "\" with body : " + message);
    }
    
    /**
     * Sends email to a particular email and also sends email to all of their friend of friend
     * @param emailAddress - To whom the email should be sent
     * @param message - Message body of the email.
     * @param friendsArray - 2D array , where 1st coloumn is email id of a person
     * and 2nd coloumn is comma separated values of contact's email id of the same person.
     */
    public void sendMail(String emailAddress, String message, String[][] friendsArray){
        Set<String> finalList = friendChain(emailAddress, friendsArray);
        
        finalList.forEach( email -> {
            sendMail(email, message);
        });
    }
    
    /**
     * Returns Set of email addresses of all friends of a person 
     * and email id of his friends of friends too
     * @param emailAddress - person whose friend chain to be extracted from 2D array
     * @param friendsArray - 2D array , where 1st coloumn is email id of a person
     * and 2nd coloumn is comma separated values of contact's email id of the same person.
     * @return - Set of email addresses of friend chain of given person
     */
    public Set friendChain(String emailAddress, String[][] friendsArray){
        Set<String> finalList = new HashSet<String>();
        
        return friendChain(emailAddress, emailAddress, finalList, friendsArray);
    }
    
    /**
     * Overloaded private method to hide startingEmailAddress & finalList parameters.
     * As they are used only for calculations 
     * and end user of this class should not interfere with it
     * @param startingEmailAddress - email address from which the chain starts 
     * & used as stopping param of recursive funtion
     * @param emailAddress - email address of whom friend chain to be calculated.
     * @param finalList - This Set is passed around in recursive calls,
     * so that a single Set can be maintained & duplicates can be removed.
     * @param friendsArray - 2D array , where 1st coloumn is email id of a person
     * and 2nd coloumn is comma separated values of contact's email id of the same person.
     * @return 
     */
    private Set friendChain(String startingEmailAddress, String emailAddress, Set finalList, String[][] friendsArray){
        
        int indexOfEmail = findIndexOf(emailAddress, friendsArray);
        
        if(emailAddress.equalsIgnoreCase(startingEmailAddress)){
            if(finalList.contains(emailAddress)){
                return finalList;
            }
        }
        
        finalList.add(emailAddress);
        if(indexOfEmail<0)
            return finalList;
        
        String[] friendsEmailArray = friendsArray[indexOfEmail][1].split(",");
        
        for(int i = 0; i < friendsEmailArray.length; i++){
            friendChain(startingEmailAddress, friendsEmailArray[i], finalList, friendsArray);
        }
        return finalList;
    }
    
    /**
     * Find the index of row of the given email id in given 2D array
     * @param emailAddress - Whose index to be found
     * @param friendsArray - 2D array in which index to be searched from
     * @return 
     */
    public int findIndexOf(String emailAddress, String[][] friendsArray){
        int result = -1;
        for(int i = 0; i < friendsArray.length; i++){
            if(emailAddress.equalsIgnoreCase(friendsArray[i][0])){
                result = i;
                break;
            }
        }
        return result;
    }
}
