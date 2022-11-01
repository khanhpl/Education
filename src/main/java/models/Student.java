/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.ElementCollection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@XmlRootElement(name="student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    
    @XmlAttribute
    private String studentID;
    private String name;
    private String email;
    private int phone;
    
    private Avatar avatar;

    public Student() {
    }

    public Student(String studentID, String name, String email, int phone, Avatar avatar) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
    }

    public Student(String studentID, String name, String email, int phone) {
        this.studentID = studentID;
        this.name = name;
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

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", avatar=" + avatar + '}';
    }

   
    
}
