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
    
    public void sendMail(String emailAddress, String message){
        System.out.println("Sending mail to : \"" + emailAddress + "\" with body : " + message);
    }
    
    public void sendMail(String emailAddress, String message, String[][] friendsArray){
        Set<String> finalList = new HashSet<String>();
        
        friendChain(emailAddress, finalList, friendsArray);
        
        finalList.forEach( email -> {
            sendMail(email, message);
        });
    }
    
    public Set friendChain(String emailAddress, Set finalList, String[][] friendsArray){
        return friendChain(emailAddress, emailAddress, finalList, friendsArray);
    }
    
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
