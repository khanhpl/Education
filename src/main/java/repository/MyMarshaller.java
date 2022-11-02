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

    public static void saveData(School school) {
        try {
            JAXBContext jc = JAXBContext.newInstance(School.class);
            javax.xml.bind.Marshaller m = jc.createMarshaller();
            m.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(school, new File("D:\\XML\\Education\\project.xml"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
