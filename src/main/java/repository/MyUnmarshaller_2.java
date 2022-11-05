/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import models.AccountData.Hrusers;
/**
 *
 * @author HP
 */
public class MyUnmarshaller_2 {
    public static Hrusers getDataFromXml() {
        File xmlFile = new File("C:\\Users\\HP\\OneDrive\\Desktop\\Education\\hrusers.xml");

        
        Hrusers hrusers = null;
        
        try {
            JAXBContext jc = JAXBContext.newInstance(Hrusers.class);
            Unmarshaller un = jc.createUnmarshaller();
            hrusers = (Hrusers) un.unmarshal(xmlFile);
                     
        } catch (Exception je) {
            System.out.println(je.getMessage());
        }
        return hrusers;
    }
}
