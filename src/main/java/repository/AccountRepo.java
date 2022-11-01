/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import models.Account;

/**
 *
 * @author HP
 */
public class AccountRepo {
    private static final ArrayList<Account> TEACHERS = new ArrayList<>();
    
    public static void initDataAccount(){
        TEACHERS.add(new Account("duy", "123456"));
    }
    
    public static ArrayList<Account> read (){
        return AccountRepo.TEACHERS;
    }
    
    public static Account details(String username){
        for (Account account : TEACHERS) {
            if(account.getName().equalsIgnoreCase(username)){
                return account;
            }
        }
        return null;
    }
    
    public static boolean checkLogin(String u, String p){
        Account a = details(u);
        if(a != null){
            if(a.getPassword().equalsIgnoreCase(p))
            return true;
        }   
        return false;
    }
}
