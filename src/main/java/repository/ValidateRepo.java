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
import models.Teacher;
import models.TeacherValidate;

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
            classID = "Vui l??ng nh???p m?? l???p!";
        } else {
            if (!classInput.getClassID().matches("[a-zA-Z]{2}[0-9]{4}")) {
                classID = "Nh???p theo format xxNNNN v???i x l?? ch??? v?? N l?? s???";
            }
        }

        //thoi gian bat dau
        if (classInput.getTimeStart().isEmpty() || classInput.getTimeStart().trim() == "") {
            timeStart = "Vui l??ng nh???p th???i gian b???t ?????u!";
        } else {
            if (!classInput.getTimeStart().matches("[0-9]{1,2}")) {
                timeStart = "Th???i gian kh??ng h???p l???";
            }
        }

//        thoi gian ket thuc
        if (classInput.getTimeEnd().isEmpty() || classInput.getTimeEnd().trim() == "") {
            timeEnd = "Vui l??ng nh???p th???i gian k???t th??c!";
        } else {
            if (!classInput.getTimeEnd().matches("[0-9]{1,2}")) {
                timeEnd = "Th???i gian kh??ng h???p l???";
            }
        }

        //ma mon
        if (classInput.getSubject().getSubjectID().isEmpty() || classInput.getSubject().getSubjectID().trim() == "") {
            subjectID = "Vui l??ng nh???p m?? m??n";
        } else {
            if (!classInput.getSubject().getSubjectID().matches("[a-zA-Z]{2,4}[a-zA-Z0-9]{0,4}")) {
                subjectID = "M?? m??n kh??ng h???p l???";
            } else {
                if (!checkClassID(classInput.getClassID(), classInput.getSubject().getSubjectID())) {
                    subjectID = "M??n h???c n??y ???? c?? gi??o vi??n kh??c d???y";
                }
            }

        }

        //ten mon
        if (classInput.getSubject()
                .getSubjectName().isEmpty() || classInput.getSubject().getSubjectName().trim() == "") {
            subjectName = "Vui l??ng nh???p t??n m??n h???c";
        }

        ClassesValidate nofi = new ClassesValidate(classID, timeStart, timeEnd, subjectID, subjectName);
        return nofi;
    }

    public static boolean checkInputStudent(String subjectID, Student student) {
        boolean check = true;
        //ma sinh vien
        if (student.getStudentID().isEmpty() || student.getStudentID().trim() == "") {
            check = false;
        }
        if (!student.getStudentID().matches("[a-zA-Z]{2}[0-9]{6,7}")) {
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

    public static StudentValidate nofiInputStudent(String subjectID, Student student) {
        String studentID = "";
        String studentName = "";
        String email = "";
        String phoneNo = "";
        if (student.getStudentID().isEmpty() || student.getStudentID().trim() == "") {
            studentID = "Vui l??ng nh???p t??n sinh vi??n";
        } else {
            if (!student.getStudentID().matches("[a-zA-Z]{2}[0-9]{6,7}")) {
                studentID = "Nh???p theo d???ng wwDDDDDD v???i w l?? ch??? c??i v?? D l?? s??? t??? 6 ho???c 7 s??? ";
            } else {
                if (!checkStudentID(subjectID, student.getStudentID())) {
                    studentID = "B???n ???? ????ng k?? m??n h???c n??y r???i";
                }
            }
        }

        //ten sinh vien
        if (student.getName().isEmpty() || student.getName().trim() == "") {
            studentName = "Vui l??ng nh???p t??n sinh vi??n";
        }

        //email
        if (student.getEmail().isEmpty() || student.getEmail().trim() == "") {
            email = "Vui l??ng nh???p email";
        } else {
            if (!student.getEmail().matches("[a-zA-Z0-9]{4,}@[a-zA-Z0-9]{2,5}(.[a-zA-Z0-9]{2,5}){1,3}")) {
                email = "Email kh??ng h???p l???";
            }
        }

        //so dien thoai
        if (student.getPhone().isEmpty() || student.getPhone() == "") {
            phoneNo = "Vui l??ng nh???p s??? ??i???n tho???i";
        } else {
            if (!student.getPhone().matches("0[1-9][0-9]{8,9}")) {
                phoneNo = "S??? ??i???n tho???i kh??ng h???p l???";
            }
        }

        StudentValidate studentVali = new StudentValidate(studentID, studentName, email, phoneNo);
        return studentVali;
    }

    public static boolean checkInputTeacher(Teacher teacherInput) {
        boolean check = true;
        if (teacherInput.getTeacherID().isEmpty() || teacherInput.getTeacherID().trim() == "") {
            check = false;
        }
        if (!teacherInput.getTeacherID().matches("([a-zA-Z]{3,}[0-9]{0,}){1,}")) {
            check = false;
        }

        if (teacherInput.getName().isEmpty() || teacherInput.getName().trim() == "") {
            check = false;
        }

        if (teacherInput.getEmail().isEmpty() || teacherInput.getEmail().trim() == "") {
            check = false;
        }
        if (!teacherInput.getEmail().matches("[a-zA-Z0-9]{4,}@[a-zA-Z0-9]{2,5}(.[a-zA-Z0-9]{2,5}){1,3}")) {
            check = false;
        }

 
        if (teacherInput.getPhone().isEmpty() || teacherInput.getPhone() == "") {
            check = false;
        }
        if (!teacherInput.getPhone().matches("^0[1-9][0-9]{8,9}")) {
            check = false;
        }

        return check;
    }

    public static TeacherValidate nofiInputTeacher(Teacher teacher) {
        String teacherID = "";
        String teacherName = "";
        String email = "";
        String phone = "";
        if (teacher.getTeacherID().isEmpty() || teacher.getTeacherID().trim() == "") {
            teacherID = "Vui l??ng nh???p ID gi??o vi??n";
        } else {
            if (!teacher.getTeacherID().matches("([a-zA-Z]{3,}[0-9]{0,}){1,}")) {
                teacherID = "Nh???p ch??? c??i v?? s???, kh??ng g???m c??c k?? t??? ?????c bi???t";
            } else {
                if (!checkTeacherID(teacher.getTeacherID())) {
                    teacherID = "M?? gi??o vi??n ???? t???n t???i";
                }
            }
        }

        //ten sinh vien
        if (teacher.getName().isEmpty() || teacher.getName().trim() == "") {
            teacherName = "Vui l??ng nh???p t??n gi??o vi??n";
        }

        //email
        if (teacher.getEmail().isEmpty() || teacher.getEmail().trim() == "") {
            email = "Vui l??ng nh???p email";
        } else {
            if (!teacher.getEmail().matches("[a-zA-Z0-9]{4,}@[a-zA-Z0-9]{2,5}(.[a-zA-Z0-9]{2,5}){1,3}")) {
                email = "Email kh??ng h???p l???";
            }
        }

        //so dien thoai
        if (teacher.getPhone().isEmpty() || teacher.getPhone() == "") {
            phone = "Vui l??ng nh???p s??? ??i???n tho???i";
        } else {
            if (!teacher.getPhone().matches("0[1-9][0-9]{8,9}")) {
                phone = "S??? ??i???n tho???i kh??ng h???p l???";
            }
        }

        TeacherValidate t = new TeacherValidate(teacherID, teacherName, email, phone);
        return t;
    }

    public static boolean checkClassID(String classID, String subjectID) {
        boolean check = true;
        List<Teacher> listTeacher = SchoolRepo.schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            List<Classes> listClasseses = listTeacher.get(i).getListClasses();
            for (int j = 0; j < listClasseses.size(); j++) {
                if (listClasseses.get(j).getClassID().equalsIgnoreCase(classID) && listClasseses.get(j).getSubject().getSubjectID().equalsIgnoreCase(subjectID)) {
                    check = false;
                }
            }
        }
        return check;
    }

    public static boolean checkStudentID(String subjectID, String studentID) {
        boolean check = true;
        List<Teacher> listTeachers = SchoolRepo.schoolData.getTeacher();
        for (int i = 0; i < listTeachers.size(); i++) {
            List<Classes> listClasseses = listTeachers.get(i).getListClasses();
            for (int j = 0; j < listClasseses.size(); j++) {
                List<Student> listStudents = listClasseses.get(j).getStudents();
                for (int z = 0; z < listStudents.size(); z++) {
                    if (listStudents.get(z).getStudentID().equalsIgnoreCase(studentID) && listClasseses.get(j).getSubject().getSubjectID().equalsIgnoreCase(subjectID)) {
                        check = false;
                    }
                }
            }
        }
        return check;
    }

    public static boolean checkTeacherID(String teacherID) {
        boolean check = true;
        List<Teacher> listTeacher = SchoolRepo.schoolData.getTeacher();
        for (int i = 0; i < listTeacher.size(); i++) {
            if (listTeacher.get(i).getTeacherID().equalsIgnoreCase(teacherID)) {
                check = false;
            }
        }
        return check;
    }

    public static void main(String[] args) {
//        SchoolRepo.read();
//        StudentValidate st = new StudentValidate("se123456", "123", "123", "123");
//        System.out.println(nofiInputStudent("aaaa", st));

    }

}
