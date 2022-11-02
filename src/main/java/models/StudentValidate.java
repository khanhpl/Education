/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author nhn19
 */
public class StudentValidate {
   private String studentID;
   private String name;
   private String email;
   private String phone;


    public StudentValidate() {
    }


    public StudentValidate(String studentID, String studentName, String email, String phone) {
        this.studentID = studentID;
        this.name = studentName;
        this.email = email;
        this.phone = phone;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "StudentValidate{" + "studentID=" + studentID + ", name=" + name + ", email=" + email + ", phone=" + phone + '}';
    }
   
   
}
