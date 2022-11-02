/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@XmlRootElement(name = "school")
@XmlAccessorType(XmlAccessType.FIELD)
public class School {

    @XmlAttribute
    private String schoolName;

    private List<Teacher> teacher;

    public School() {
        schoolName = "FPT";
    }

    public School(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "School{" + "schoolName=" + schoolName + ", teacher=" + teacher + '}';
    }


}
