/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.Classes;
import models.School;
import models.Student;
import models.Subject;
import models.Teacher;

/**
 *
 * @author nhn19
 */
public class SchoolRepo {
    
    public static School schoolData = new School();
    
    public static School read() {
        schoolData = MyUnmarshaller.getDataFromXml();
        return schoolData;
    }
    
    public static void load() {
        schoolData = MyUnmarshaller.getDataFromXml();
        
    }
    
    public static void save() {
        MyMarshaller.saveData(schoolData);
    }
    
    public static void createTeacher(Teacher t) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        listTeacher.add(t);
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID() == "") {
                listTeacher.remove(i);
            }
        }
        save();
    }
    
    public static void createClass(String teacherID, Classes c) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                List<Classes> listClass = listTeacher.get(i).getListClasses();
                listClass.add(c);
                for (int j = 0; j < listClass.size(); j++) {
                    if (listClass.get(j).getClassID() == "") {
                        listClass.remove(j);
                    }
                }
            }
        }
        save();
    }
    
    public static void createStudent(String teacherID, String classID, String subjectID, Student s) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                List<Classes> listClass = listTeacher.get(i).getListClasses();
                for (int j = 0; j < listClass.size(); j++) {
                    if (listClass.get(j).getClassID().equalsIgnoreCase(classID) && listClass.get(j).getSubject().getSubjectID().equalsIgnoreCase(subjectID)) {
                        List<Student> listStudent = listClass.get(j).getStudents();
                        listStudent.add(s);
                        for (int z = 0; z < listStudent.size(); z++) {
                            if (listStudent.get(z).getStudentID() == "") {
                                listStudent.remove(z);
                            }
                        }
                    }
                }
            }
        }
        save();
    }
    
    public static Teacher detailTeacher(String teacherId) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        System.out.println(listTeacher);
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherId)) {
                return listTeacher.get(i);
            }
        }
        return null;
    }
    
    public static Classes detailClass(String teacherID, String classID, String subjectID) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                List<Classes> listClass = listTeacher.get(i).getListClasses();
                for (int j = 0; j < listClass.size(); j++) {
                    if (listClass.get(j).getClassID().equalsIgnoreCase(classID) && listClass.get(j).getSubject().getSubjectID().equalsIgnoreCase(subjectID)) {
                        return listClass.get(j);
                    }
                }
            }
        }
        
        return null;
    }
    
    public static Student detailStudent(String teacherID, String classID, String studentID) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                List<Classes> listClass = listTeacher.get(i).getListClasses();
                for (int j = 0; j < listClass.size(); j++) {
                    if (listClass.get(j).getClassID().equalsIgnoreCase(classID)) {
                        List<Student> listStudent = listClass.get(j).getStudents();
                        for (int z = 0; z < listStudent.size(); z++) {
                            if (listStudent.get(z).getStudentID().equalsIgnoreCase(studentID)) {
                                return listStudent.get(z);
                            }
                        }
                    }
                }
            }
        }
        
        return null;
    }
    
    public static void updateTeacher(String teacherID, Teacher t) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                listTeacher.get(i).setName(t.getName());
                listTeacher.get(i).setEmail(t.getEmail());
                listTeacher.get(i).setPhone(t.getPhone());
            }
        }
        save();
    }
    
    public static void updateClass(String teacherID, String classID, String subjectIDOdd, Classes c) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                List<Classes> listClass = listTeacher.get(i).getListClasses();
                for (int j = 0; j < listClass.size(); j++) {
                    if (listClass.get(j).getClassID().equalsIgnoreCase(classID) && listClass.get(j).getSubject().getSubjectID().equalsIgnoreCase(subjectIDOdd)) {
                        listClass.get(j).setSubject(c.getSubject());
                        listClass.get(j).setTimeStart(c.getTimeStart());
                        listClass.get(j).setTimeEnd(c.getTimeEnd());
                    }
                }
            }
        }
        save();
    }
    
    public static void updateStudent(String studentID, Student s) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            List<Classes> listcClasseses = listTeacher.get(i).getListClasses();
            for (int j = 0; j < listcClasseses.size(); j++) {
                List<Student> listsStudents = listcClasseses.get(j).getStudents();
                for (int z = 0; z < listsStudents.size(); z++) {
                    if (listsStudents.get(z).getStudentID().equalsIgnoreCase(studentID)) {
                        listsStudents.get(z).setName(s.getName());
                        listsStudents.get(z).setEmail(s.getEmail());
                        listsStudents.get(z).setPhone(s.getPhone());
                    }
                }
            }
            
        }
        save();
    }
    
    public static void deleteTeacher(String teacherID) {
        List<Teacher> listTeachers = schoolData.getTeacher();
        for (int i = 0; i < listTeachers.size(); i++) {
            if (listTeachers.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                listTeachers.remove(i);
                if (listTeachers.isEmpty() || listTeachers == null) {
                    Teacher t = teacherNull();
                    listTeachers.add(t);
                }
            }
        }
        save();
    }
    
    public static void deleteClass(String teacherID, String classID, String subjectID) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                List<Classes> listClasseses = listTeacher.get(i).getListClasses();
                for (int j = 0; j < listClasseses.size(); j++) {
                    if (listClasseses.get(j).getClassID().equalsIgnoreCase(classID) && listClasseses.get(j).getSubject().getSubjectID().equalsIgnoreCase(subjectID)) {
                        listClasseses.remove(j);
                        if (listClasseses.isEmpty() || listClasseses == null) {
                            Classes c = classNull();
                            listClasseses.add(c);
                        }
                    }
                }
            }
        }
        save();
    }
    
    public static void deleteStudent(String teacherID, String classID, String studentID) {
        List<Teacher> listTeacher = schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                List<Classes> listClasseses = listTeacher.get(i).getListClasses();
                for (int j = 0; j < listClasseses.size(); j++) {
                    if (listClasseses.get(j).getClassID().equalsIgnoreCase(classID)) {
                        List<Student> listStudents = listClasseses.get(j).getStudents();
                        for (int z = 0; z < listStudents.size(); z++) {
                            if (listStudents.get(z).getStudentID().equalsIgnoreCase(studentID)) {
                                listStudents.remove(z);
                                Student s = studentNull();
                                listStudents.add(s);
                            }
                        }
                    }
                }
            }
        }
        save();
    }
    
    public static Student studentNull() {
        String studentID = "";
        String name = "";
        String email = "";
        String phone = "";
        
        Student s = new Student(studentID, name, email, phone);
        return s;
    }
    
    public static Classes classNull() {
        String classID = "";
        String timeStart = "";
        String timeEnd = "";
        String subjectID = "";
        String subjectName = "";
        Subject su = new Subject(subjectID, subjectName);
        Student s = studentNull();
        
        List<Student> li = new ArrayList<>();
        li.add(s);
        
        Classes c = new Classes(classID, timeStart, timeEnd, su, li);
        return c;
    }
    
    public static Teacher teacherNull() {
        String teacherID = "";
        String name = "";
        String email = "";
        String phone = "";
        
        Classes c = classNull();
        List<Classes> li = new ArrayList<>();
        li.add(c);
        
        Teacher t = new Teacher(teacherID, name, email, phone, li);
        
        return t;
    }
    
    public static void main(String[] args) {
        //Test chức năng
        SchoolRepo.read();
        System.out.println(schoolData);
        deleteTeacher("namnh6");
    }
    
}
