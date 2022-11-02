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
    private String phone;
    
    @XmlElement(name = "class")
    private List<Classes> listClasses;

    public Teacher() {
    }

    public Teacher(String teacherID, String name, String email, String phone) {
        this.teacherID = teacherID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Teacher(String teacherID, String name, String email, String phone, List<Classes> listClasses) {
        this.teacherID = teacherID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.listClasses = listClasses;
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

    public List<Classes> getListClasses() {
        return listClasses;
    }

    public void setListClasses(List<Classes> listClasses) {
        this.listClasses = listClasses;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teacherID=" + teacherID + ", name=" + name + ", email=" + email + ", phone=" + phone + ", listClasses=" + listClasses + '}';
    }

   
}
