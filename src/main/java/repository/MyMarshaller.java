/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import models.Avatar;
import models.Classes;
import models.School;
import models.Student;
import models.Subject;
import models.Teacher;

/**
 *
 * @author HP
 */
public class MyMarshaller {

    public static void main(String[] args) {

        Teacher t = new Teacher();
        t.setTeacherID("namh6");
        t.setName("Mr. Nam");
        t.setEmail("namh3@fpt.edu.vn");
        t.setPhone(01234567);
        Avatar avatarTeacher = new Avatar("https://pickaface.net/gallery/avatar/karl52d63034e0a8a.png");
        t.setAvatar(avatarTeacher);
        List<Classes> listClass = new LinkedList<>();
        //Lop XML
        Classes class1 = new Classes();
        class1.setClassID("se1509");
        class1.setTimeStart("7");
        class1.setTimeEnd("9");
        Subject s = new Subject();
        s.setSubjectID("prx");
        s.setSubjectName("XML");
        class1.setSubject(s);
        List<Student> students1 = new ArrayList<>();
        Student s1 = new Student();
        s1.setStudentID("se130739");
        s1.setName("Phan Lưu Khánh");
        s1.setEmail("khanhplse130739@fpt.edu.vn");
        s1.setPhone(01234500);
        Avatar avatarStudent1 = new Avatar("https://thumbs.dreamstime.com/b/people-avatar-icons-student-student-avatar-icon-colors-193586658.jpg");
        s1.setAvatar(avatarStudent1);
        students1.add(s1);
        Student s2 = new Student();
        s2.setStudentID("se140985");
        s2.setName("Hồ Vĩnh Duy");
        s2.setEmail("duyhvse140985@fpt.edu.vn");
        s2.setPhone(01235711);
        Avatar avatarStudent2 = new Avatar("https://thumbs.dreamstime.com/b/people-avatar-icons-student-student-avatar-icon-colors-193586658.jpg");
        s2.setAvatar(avatarStudent1);
        students1.add(s2);
        Student s3 = new Student();
        s3.setStudentID("se123571");
        s3.setName("Huỳnh Nhật Duy");
        s3.setEmail("duyhnse62571@fpt.edu.vn");
        s3.setPhone(013736423);
        Avatar avatarStudent3 = new Avatar("https://thumbs.dreamstime.com/b/people-avatar-icons-student-student-avatar-icon-colors-193586658.jpg");
        s3.setAvatar(avatarStudent3);
        students1.add(s3);
        Student s4 = new Student();
        s4.setStudentID("se140888");
        s4.setName("Nguyễn Hồng Nhân");
        s4.setEmail("nhannhse140888@fpt.edu.vn");
        s4.setPhone(013736423);
        Avatar avatarStudent4 = new Avatar("https://thumbs.dreamstime.com/b/people-avatar-icons-student-student-avatar-icon-colors-193586658.jpg");
        s4.setAvatar(avatarStudent4);
        students1.add(s4);
        class1.setStudents(students1);
        listClass.add(class1);
        // class 2
        Classes class2 = new Classes();
        class2.setClassID("se1555");
        class2.setTimeStart("8");
        class2.setTimeEnd("10");
        Subject s123 = new Subject();
        s123.setSubjectID("ssc");
        s123.setSubjectName("SSC");
        class2.setSubject(s123);
        List<Student> students2 = new ArrayList<>();
        Student s12 = new Student();
        s12.setStudentID("se130739");
        s12.setName("Phan Lưu Khánh");
        s12.setEmail("khanhplse130739@fpt.edu.vn");
        s12.setPhone(01234500);
        Avatar avatarStudent12 = new Avatar("https://thumbs.dreamstime.com/b/people-avatar-icons-student-student-avatar-icon-colors-193586658.jpg");
        s12.setAvatar(avatarStudent12);
        students2.add(s12);
        Student s22 = new Student();
        s22.setStudentID("se140985");
        s22.setName("Hồ Vĩnh Duy");
        s22.setEmail("duyhvse140985@fpt.edu.vn");
        s22.setPhone(01235711);
        Avatar avatarStudent22 = new Avatar("https://thumbs.dreamstime.com/b/people-avatar-icons-student-student-avatar-icon-colors-193586658.jpg");
        s22.setAvatar(avatarStudent22);
        students2.add(s22);
        Student s32 = new Student();
        s32.setStudentID("se123571");
        s32.setName("Huỳnh Nhật Duy");
        s32.setEmail("duyhnse62571@fpt.edu.vn");
        s32.setPhone(013736423);
        Avatar avatarStudent32 = new Avatar("https://thumbs.dreamstime.com/b/people-avatar-icons-student-student-avatar-icon-colors-193586658.jpg");
        s32.setAvatar(avatarStudent32);
        students2.add(s32);
        Student s42 = new Student();
        s42.setStudentID("se140888");
        s42.setName("Nguyễn Hồng Nhân");
        s42.setEmail("nhannhse140888@fpt.edu.vn");
        s42.setPhone(013736423);
        Avatar avatarStudent42 = new Avatar("https://thumbs.dreamstime.com/b/people-avatar-icons-student-student-avatar-icon-colors-193586658.jpg");
        s42.setAvatar(avatarStudent42);
        students2.add(s42);
        class2.setStudents(students2);
        listClass.add(class2);
        t.setListClasses(listClass);
        System.out.println(t);
        School school = new School(t);
        //luu du lieu
        saveData(school);

    }

    public static void saveData(School school) {
        try {
            JAXBContext jc = JAXBContext.newInstance(School.class);
            javax.xml.bind.Marshaller m = jc.createMarshaller();
            m.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(school, new File("D:\\XML\\FinalAssignment\\project.xml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
