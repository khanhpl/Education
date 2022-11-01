/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@XmlRootElement(name = "teacher")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher {
    @XmlAttribute
    private String teacherID;
   
    private String name;
    private String email;
    private int phone;
    private Avatar avatar;
    
    @XmlElement(name = "class")
    private List<Classes> listClasses;

    public Teacher() {
    }

    public Teacher(String teacherID, String name, String email, int phone, Avatar avatar, List<Classes> listClasses) {
        this.teacherID = teacherID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
        this.listClasses = listClasses;
    }

    public Teacher(String teacherID, String name, String email, int phone, Avatar avatar) {
        this.teacherID = teacherID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public List<Classes> getListClasses() {
        return listClasses;
    }

    public void setListClasses(List<Classes> listClasses) {
        this.listClasses = listClasses;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherID=" + teacherID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", avatar=" + avatar + ", listClasses=" + listClasses + '}';
    }

   

   
        
}
