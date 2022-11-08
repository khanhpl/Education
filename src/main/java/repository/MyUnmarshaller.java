/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import models.School;

/**
 *
 * @author HP
 */
public class MyUnmarshaller {

    public static void main(String[] args) {
        School school = new School();
        school = getDataFromXml();
        System.out.println(school);
    }

    public static School getDataFromXml() {
        File xmlFile = new File("D:\\XML\\Education\\project.xml");

        
        School school = null;
        
        try {
            JAXBContext jc = JAXBContext.newInstance(School.class);
            Unmarshaller un = jc.createUnmarshaller();
            school = (School) un.unmarshal(xmlFile);
                     
        } catch (Exception je) {
            System.out.println(je.getMessage());
        }
        return school;
    }

}
