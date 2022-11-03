/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.Account;

/**
 *
 * @author HP
 */
public class AccountRepo {
    private static final ArrayList<Account> TEACHERS = new ArrayList<>();
    
    public static void initDataAccount(){
        List<String> admin = new ArrayList<>();
        admin.add("ADMIN");
        List<String> supermod = new ArrayList<>();
        supermod.add("SUPERMOD");
        List<String> mod = new ArrayList<>();
        mod.add("MOD");
        List<String> editor = new ArrayList<>();
        editor.add("EDITOR");
        TEACHERS.add(new Account("duy", "123456", admin));
        TEACHERS.add(new Account("admin", "123456", admin));
        TEACHERS.add(new Account("supermod", "123456", supermod));
        TEACHERS.add(new Account("mod", "123456", mod));
        TEACHERS.add(new Account("editor", "123456", editor));
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
