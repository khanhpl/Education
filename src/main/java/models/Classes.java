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
@XmlRootElement(name = "class")
@XmlAccessorType(XmlAccessType.FIELD)
public class Classes {

    @XmlAttribute
    private String classID;
    @XmlAttribute(name = "TimeStart")
    private String timeStart;
    @XmlAttribute(name = "TimeEnd")
    private String timeEnd;
   
    private Subject subject;

    @XmlElement(name = "student")
    private List<Student> students;

    public Classes() {
    }

    public Classes(String classID, String timeStart, String timeEnd, Subject subject, List<Student> students) {
        this.classID = classID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.subject = subject;
        this.students = students;
    }

    public Classes(String classID, String timeStart, String timeEnd, Subject subject) {
        this.classID = classID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.subject = subject;
    }
    
    

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classes{" + "classID=" + classID + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", subject=" + subject + ", students=" + students + '}';
    }

   
   

}
