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
public class ClassesValidate {
    private String classID;
    private String timeStart;
    private String timeEnd;
    private String subjectID;
    private String subjectName;

    public ClassesValidate() {
    }

    public ClassesValidate(String classID, String timeStart, String timeEnd, String subjectID, String subjectName) {
        this.classID = classID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.subjectID = subjectID;
        this.subjectName = subjectName;
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

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "ClassesValidate{" + "classID=" + classID + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", subjectID=" + subjectID + ", subjectName=" + subjectName + '}';
    }
    
    
}
