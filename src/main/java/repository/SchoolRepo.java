/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import models.Avatar;
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

    public static Classes detailClass(String classID) {
        List<Classes> li = schoolData.getTeacher().getListClasses();
        for (Classes classes : li) {
            if (classID.equalsIgnoreCase(classes.getClassID())) {
                return classes;
            }
        }
        return null;
    }

    public static Student detailStudent(String classID, String studentID) {
        List<Classes> listClass = schoolData.getTeacher().getListClasses();
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassID().equalsIgnoreCase(classID)) {
                List<Student> listStudent = listClass.get(i).getStudents();
                for (int j = 0; j < listStudent.size(); j++) {
                    if (listStudent.get(j).getStudentID().equalsIgnoreCase(studentID)) {
                        return listStudent.get(j);
                    }
                }
            }
        }
        return null;
    }

    public static void updateClass(Classes classes) {
        List<Classes> listClass = schoolData.getTeacher().getListClasses();
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassID().equalsIgnoreCase(classes.getClassID())) {
                listClass.set(i, classes);
            }
        }
        save();
    }

    public static void updateStudent(String classID, Student student) {
        List<Classes> listClass = schoolData.getTeacher().getListClasses();
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassID().equalsIgnoreCase(classID)) {
                List<Student> listStudent = listClass.get(i).getStudents();
                for (int j = 0; j < listStudent.size(); j++) {
                    if (listStudent.get(j).getStudentID().equalsIgnoreCase(student.getStudentID())) {
                        listStudent.set(j, student);
                    }
                }
            }
        }
        save();

    }

    public static void deleteClass(String classID) {
        List<Classes> li = schoolData.getTeacher().getListClasses();
        for (int i = 0; i < li.size(); i++) {
            if (classID.equalsIgnoreCase(li.get(i).getClassID())) {
                li.remove(i);
            }

        }
        if (li.isEmpty()) {
            String classID2 = "";
            String timeStart = "";
            String timeEnd = "";

            String subjectID = "";
            String subjectName = "";

            String studentID = "";
            String name = "";
            String email = "";
            int phone = 0;
            String url = "";
            Avatar a = new Avatar(url);

            Student st = new Student(studentID, name, email, phone, a);
            List<Student> listStudent = new ArrayList<>();
            listStudent.add(st);

            Subject s = new Subject(subjectID, subjectName);

            Classes classNull = new Classes(classID2, timeStart, timeEnd, s, listStudent);
            li.add(classNull);
        }
        save();

    }

    public static void deleteStudent(String classID, String studentID) {
        List<Classes> listClass = schoolData.getTeacher().getListClasses();
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassID().equalsIgnoreCase(classID)) {
                List<Student> listStudent = listClass.get(i).getStudents();
                for (int j = 0; j < listStudent.size(); j++) {
                    if (listStudent.get(j).getStudentID().equalsIgnoreCase(studentID)) {
                        listStudent.remove(j);
                        if (listStudent.isEmpty()) {
                            String studentID2 = "";
                            String name = "";
                            String email = "";
                            int phone = 0;
                            String url = "";
                            Avatar a = new Avatar(url);

                            Student studentNull = new Student(studentID2, name, email, phone, a);
                            listStudent.add(studentNull);
                        }

                    }
                }
            }
        }
        save();

    }

    public static void createClass(Classes c) {
        List<Classes> listClass = schoolData.getTeacher().getListClasses();
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassID() == "") {
                listClass.remove(i);
            }
        }

        listClass.add(c);
        save();

    }

    public static void createStudent(String classID, Student s) {

        List<Classes> listClas = schoolData.getTeacher().getListClasses();
        for (int i = 0; i < listClas.size(); i++) {

            if (listClas.get(i).getClassID().equalsIgnoreCase(classID)) {
                List<Student> listStudent = listClas.get(i).getStudents();
                listStudent.add(s);
                for (int j = 0; j < listStudent.size(); j++) {
                    if (listStudent.get(j).getStudentID() == "") {
                        listStudent.remove(j);
                    }
                }

            }

        }
        save();

        System.out.println(listClas);
    }

    //Teacher repo
    public static Teacher detailTeacher(String teacherId) {
        Teacher t = schoolData.getTeacher();
        if (t.getTeacherID().equalsIgnoreCase(teacherId)) {
            return t;
        }
        return null;
    }

    public static void updateTeacher(Teacher _teacher) {
        Teacher t = schoolData.getTeacher();
        if (t.getTeacherID().equalsIgnoreCase(_teacher.getTeacherID())) {
            t.setTeacherID(_teacher.getTeacherID());
            t.setName(_teacher.getName());
            t.setEmail(_teacher.getEmail());
            t.setPhone(_teacher.getPhone());
            t.setAvatar(_teacher.getAvatar());
        }
        save();
    }

    public static void main(String[] args) {
        //Test chức năng
       SchoolRepo.read();
        System.out.println(detailTeacher("namh6"));
    }

}
