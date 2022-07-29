/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecamunicipal;

/**
 *
 * @author Iam Fernandez
 */
public class User {
    private String username;
    private int useridentification;
    private String date;
    private int bookcode; 
    
    public void User(){
        username = "";
        useridentification = 0;
        date = "";
        bookcode = 0;            
    }
    
    public void setUserName(String usn) {
        username= usn;
    }
    public void setUserIdentification(int id) {
        useridentification= id;
    }
     public void setDate(String dt) {
        date = dt;
    }
      public void setBookCode(int bc) {
        bookcode = bc;
    }
      
    public String getUserName() {
        return username;
    }
    public int getUserIdentification() {
        return useridentification;
    }
    public String getDate() {
        return date;
    }
    public int getBookCode() {
        return bookcode;
    }
 
}



