/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author 828200
 */
public class AccountService {
    String username;
    String password;

    public AccountService(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User login(String username, String password)
    {
       User user=new User(username,password);
       if(password.equals("password")&&(username.equals("abe")|| username.equals("barb")))
       {
           user.setPassword(null);
           return user;
       }
       else
       {
           return null;
       }
        
    }
}
