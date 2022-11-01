/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import javax.naming.NoInitialContextException;
import models.Classes;
import models.ClassesValidate;
import models.Student;
import models.StudentValidate;
import models.Subject;

/**
 *
 * @author nhn19
 */
public class ValidateRepo {

    public static boolean checkInputClasses(Classes classInput) {
        //ma lop
        boolean check = true;
        if (classInput.getClassID().isEmpty() || classInput.getClassID().trim() == "") {
            check = false;
        }
        if (!classInput.getClassID().matches("[a-zA-Z]{2}[0-9]{4}")) {
            check = false;
        }
        if (!checkClassID(classInput.getClassID())) {
            check = false;
        }

        //thoi gian bat dau
        if (classInput.getTimeStart().isEmpty() || classInput.getTimeStart().trim() == "") {
            check = false;
        }
        if (!classInput.getTimeStart().matches("[0-9]{1,2}")) {
            check = false;
        }

//        thoi gian ket thuc
        if (classInput.getTimeEnd().isEmpty() || classInput.getTimeEnd().trim() == "") {
            check = false;
        }
        if (!classInput.getTimeEnd().matches("[0-9]{1,2}")) {
            check = false;
        }

        //ma mon
        if (classInput.getSubject().getSubjectID().isEmpty() || classInput.getSubject().getSubjectID().trim() == "") {
            check = false;
        }
        if (!classInput.getSubject().getSubjectID().matches("[a-zA-Z]{2,4}[a-zA-Z0-9]{0,4}")) {
            check = false;
        }

        //ten mon
        if (classInput.getSubject().getSubjectName().isEmpty() || classInput.getSubject().getSubjectName().trim() == "") {
            check = false;
        }
        return check;
    }

    public static ClassesValidate nofiInputClasses(Classes classInput) {
        String classID = "";
        String timeStart = "";
        String timeEnd = "";
        String subjectID = "";
        String subjectName = "";

        //ma lop
        if (classInput.getClassID().isEmpty() || classInput.getClassID().trim() == "") {
            classID = "Vui lòng nhập mã lớp!";
        } else {
            if (!classInput.getClassID().matches("[a-zA-Z]{2}[0-9]{4}")) {
                classID = "Nhập theo format xxNNNN với x là chữ và N là số";
            } else {
                if (!checkInputClasses(classInput)) {
                    classID = "Mã lớp này đã tồn tại";
                }
            }
        }

        //thoi gian bat dau
        if (classInput.getTimeStart().isEmpty() || classInput.getTimeStart().trim() == "") {
            timeStart = "Vui lòng nhập thời gian bắt đầu!";
        } else {
            if (!classInput.getTimeStart().matches("[0-9]{1,2}")) {
                timeStart = "Thời gian không hợp lệ";
            }
        }

//        thoi gian ket thuc
        if (classInput.getTimeEnd().isEmpty() || classInput.getTimeEnd().trim() == "") {
            timeEnd = "Vui lòng nhập thời gian kết thúc!";
        } else {
            if (!classInput.getTimeEnd().matches("[0-9]{1,2}")) {
                timeEnd = "Thời gian không hợp lệ";
            }
        }

        //ma mon
        if (classInput.getSubject().getSubjectID().isEmpty() || classInput.getSubject().getSubjectID().trim() == "") {
            subjectID = "Vui lòng nhập mã môn";
        } else {
            if (!classInput.getSubject().getSubjectID().matches("[a-zA-Z]{2,4}[a-zA-Z0-9]{0,4}")) {
                subjectID = "Mã môn không hợp lệ";
            }
        }

        //ten mon
        if (classInput.getSubject().getSubjectName().isEmpty() || classInput.getSubject().getSubjectName().trim() == "") {
            subjectName = "Vui lòng nhập tên môn học";
        }

        ClassesValidate nofi = new ClassesValidate(classID, timeStart, timeEnd, subjectID, subjectName);
        return nofi;
    }

    public static boolean checkInputStudent(String classID, StudentValidate student) {
        boolean check = true;
        //ma sinh vien
        if (student.getStudentID().isEmpty() || student.getStudentID().trim() == "") {
            check = false;
        }
        if (!student.getStudentID().matches("[a-zA-Z]{2}[0-9]{6,7}")) {
            check = false;
        }
        if (!checkStudentID(classID, student.getStudentID())) {
            check = false;
        }

        //ten sinh vien
        if (student.getName().isEmpty() || student.getName().trim() == "") {
            check = false;
        }

        //email
        if (student.getEmail().isEmpty() || student.getEmail().trim() == "") {
            check = false;
        }
        if (!student.getEmail().matches("[a-zA-Z0-9]{4,}@[a-zA-Z0-9]{2,5}(.[a-zA-Z0-9]{2,5}){1,3}")) {
            check = false;
        }

        //so dien thoai
        if (student.getPhone().isEmpty() || student.getPhone() == "") {
            check = false;
        }
        if (!student.getPhone().matches("^0[1-9][0-9]{8,9}")) {
            check = false;
        }

        return check;
    }

    public static StudentValidate nofiInputStudent(String classID, StudentValidate student) {
        String studentID = "";
        String studentName = "";
        String email = "";
        String phoneNo = "";
        if (student.getStudentID().isEmpty() || student.getStudentID().trim() == "") {
            studentID = "Vui lòng nhập tên sinh viên";
        } else {
            if (!student.getStudentID().matches("[a-zA-Z]{2}[0-9]{6,7}")) {
                studentID = "Nhập theo dạng wwDDDDDD với w là chữ cái và D là số từ 6 hoặc 7 số ";
            } else {
                if (!checkStudentID(classID, student.getStudentID())) {
                    studentID = "Mã sinh viên này đã tồn tại";
                }
            }
        }

        //ten sinh vien
        if (student.getName().isEmpty() || student.getName().trim() == "") {
            studentName = "Vui lòng nhập tên sinh viên";
        }

        //email
        if (student.getEmail().isEmpty() || student.getEmail().trim() == "") {
            email = "Vui lòng nhập email";
        } else {
            if (!student.getEmail().matches("[a-zA-Z0-9]{4,}@[a-zA-Z0-9]{2,5}(.[a-zA-Z0-9]{2,5}){1,3}")) {
                email = "Email không hợp lệ";
            }
        }

        //so dien thoai
        if (student.getPhone().isEmpty() || student.getPhone() == "") {
            phoneNo = "Vui lòng nhập số điện thoại";
        } else {
            if (!student.getPhone().matches("0[1-9][0-9]{8,9}")) {
                phoneNo = "Số điện thoại không hợp lệ";
            }
        }

        StudentValidate studentVali = new StudentValidate(studentID, studentName, email, phoneNo);
        return studentVali;
    }

    public static void main(String[] args) {
        String classID = "sda";
        String timeStart = "dsa";
        String timeEnd = "2";
        String subjectID = "ssds123";
        String subjectName = "fdsâss";
        Subject s = new Subject(subjectID, subjectName);
        Classes in = new Classes(classID, timeStart, timeEnd, s);

        System.out.println(nofiInputClasses(in));
    }

    public static boolean checkClassID(String classID) {
        boolean check = true;
        List<Classes> listClass = SchoolRepo.schoolData.getTeacher().getListClasses();
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassID().equalsIgnoreCase(classID)) {
                check = false;
            }
        }
        return check;
    }

    public static boolean checkStudentID(String classID, String studentID) {
        boolean check = true;
        List<Classes> listClass = SchoolRepo.schoolData.getTeacher().getListClasses();
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassID().equalsIgnoreCase(classID)) {
                List<Student> listStudent = listClass.get(i).getStudents();
                for (int j = 0; j < listStudent.size(); j++) {
                    if (listStudent.get(j).getStudentID().equalsIgnoreCase(studentID)) {
                        check = false;
                    }
                }
            }
        }
        return check;
    }

}
