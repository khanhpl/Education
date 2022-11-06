/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.Account;
import models.AccountData.Hrroles;
import models.AccountData.Hrroleuser;
import models.AccountData.Hrusers;
import models.AccountData.Role;
import models.AccountData.RoleUser;
import models.AccountData.User;

/**
 *
 * @author HP
 */
public class AccountRepo {

    public static ArrayList<Account> TEACHERS = new ArrayList<>();

    public static Hrusers hrusers = new Hrusers();
    public static List<User> listUser = new ArrayList<>();
    public static Hrroleuser hrroleuser = new Hrroleuser();
    public static List<RoleUser> listroleusers = new ArrayList<>();
    public static Hrroles hrroles = new Hrroles();
    public static List<Role> listRole = new ArrayList<>();

    public static Hrusers readDataUser() {
        hrusers = MyUnmarshaller_2.getDataFromXml();
        listUser = hrusers.getListUser();
//        System.out.println(listUser);
        return hrusers;
    }

    public static Hrroleuser readDataRoleUser() {
        hrroleuser = MyUnmarshaller_3.getDataFromXml();
        listroleusers = hrroleuser.getListRoleUser();
//        System.out.println(listroleusers);
        return hrroleuser;
    }

    public static Hrroles readDataRole() {
        hrroles = MyUnmarshaller_1.getDataFromXml();
        listRole = hrroles.getListRole();

        return hrroles;
    }

    public static void initDataAccount() {
//        List<String> admin = new ArrayList<>();
//        List<String> supermod = new ArrayList<>();
//        List<String> mod = new ArrayList<>();
//        List<String> editor = new ArrayList<>();
        List<String> roles = new ArrayList<>();
        List<String> roles1 = new ArrayList<>();
        List<String> roles2 = new ArrayList<>();
        String admin = "";
        String supermod = "";
        String mod = "";
        String editor = "";

        List<User> listU = readDataUser().getListUser();
        List<RoleUser> listRU = readDataRoleUser().getListRoleUser();
        List<Role> listR = readDataRole().getListRole();

        for (int i = 0; i < listR.size(); i++) {
            if (listR.get(i).getRoleName().equalsIgnoreCase("admin")) {
                admin = listR.get(i).getRoleName().toUpperCase();
            }
            if (listR.get(i).getRoleName().equalsIgnoreCase("supermod")) {
                supermod = listR.get(i).getRoleName().toUpperCase();
            }
            if (listR.get(i).getRoleName().equalsIgnoreCase("mod")) {
                mod = listR.get(i).getRoleName().toUpperCase();
            }
            if (listR.get(i).getRoleName().equalsIgnoreCase("editor")) {
                editor = listR.get(i).getRoleName().toUpperCase();
            }
        }

        for (int i = 0; i < listU.size(); i++) {
            for (int j = 0; j < listRU.size(); j++) {
                if (listRU.get(j).getUserID().equalsIgnoreCase("u01")) {
                    for (int k = 0; k < listR.size(); k++) {
                        if ((listU.get(i).getUserID().equalsIgnoreCase(listRU.get(j).getUserID()))
                                && listRU.get(j).getRoleID().equalsIgnoreCase(listR.get(k).getRoleID())) {

                            if (listR.get(k).getRoleName().equalsIgnoreCase("ADMIN")) {
                                roles.add(admin);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles));
                            }
                            if (listR.get(k).getRoleName().equalsIgnoreCase("SUPERMOD")) {
                                roles.add(supermod);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles));
                            }
                            if (listR.get(k).getRoleName().equalsIgnoreCase("MOD")) {
                                roles.add(mod);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles));
                            }
                            if (listR.get(k).getRoleName().equalsIgnoreCase("EDITOR")) {
                                roles.add(editor);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles));
                            }
                        }
                    }
                } else if (listRU.get(j).getUserID().equalsIgnoreCase("u02")) {
                    for (int k = 0; k < listR.size(); k++) {
                        if ((listU.get(i).getUserID().equalsIgnoreCase(listRU.get(j).getUserID()))
                                && listRU.get(j).getRoleID().equalsIgnoreCase(listR.get(k).getRoleID())) {

                            if (listR.get(k).getRoleName().equalsIgnoreCase("ADMIN")) {
                                roles1.add(admin);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles1));
                            }
                            if (listR.get(k).getRoleName().equalsIgnoreCase("SUPERMOD")) {
                                roles1.add(supermod);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles1));
                            }
                            if (listR.get(k).getRoleName().equalsIgnoreCase("MOD")) {
                                roles1.add(mod);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles1));
                            }
                            if (listR.get(k).getRoleName().equalsIgnoreCase("EDITOR")) {
                                roles1.add(editor);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles1));
                            }
                        }
                    }
                } else if (listRU.get(j).getUserID().equalsIgnoreCase("u04")) {
                    for (int k = 0; k < listR.size(); k++) {
                        if ((listU.get(i).getUserID().equalsIgnoreCase(listRU.get(j).getUserID()))
                                && listRU.get(j).getRoleID().equalsIgnoreCase(listR.get(k).getRoleID())) {

                            if (listR.get(k).getRoleName().equalsIgnoreCase("ADMIN")) {
                                roles2.add(admin);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles2));
                            }
                            if (listR.get(k).getRoleName().equalsIgnoreCase("SUPERMOD")) {
                                roles2.add(supermod);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles2));
                            }
                            if (listR.get(k).getRoleName().equalsIgnoreCase("MOD")) {
                                roles2.add(mod);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles2));
                            }
                            if (listR.get(k).getRoleName().equalsIgnoreCase("EDITOR")) {
                                roles2.add(editor);
                                TEACHERS.add(new Account(listU.get(i).getUserName(), listU.get(i).getPassword(), roles2));
                            }
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<Account> read() {
        initDataAccount();
        return AccountRepo.TEACHERS;
    }

    public static Account details(String username) {
        for (Account account : TEACHERS) {
            if (account.getName().equalsIgnoreCase(username)) {
                System.out.println(account);
                return account;
            }
        }
        return null;
    }

    public static boolean checkLogin(String u, String p) {
        Account a = details(u);
        if (a != null) {
            if (a.getPassword().equalsIgnoreCase(p)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        readDataUser();
//        readDataRoleUser();
//        readDataRole();
        initDataAccount();
        read();
        details("mrnam1");
        details("mrnam2");
        details("mrnam4");
//          System.out.println(TEACHERS);
    }
}
