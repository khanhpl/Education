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
public class TeacherValidate {

    private String teacherID;

    private String name;
    private String email;
    private String phone;

    public TeacherValidate() {
    }

    public TeacherValidate(String teacherID, String name, String email, String phone) {
        this.teacherID = teacherID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
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
        return "TeacherValidate{" + "teacherID=" + teacherID + ", name=" + name + ", email=" + email + ", phone=" + phone + '}';
    }
    
    
}
