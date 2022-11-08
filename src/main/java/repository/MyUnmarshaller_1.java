/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import models.AccountData.Hrroles;

/**
 *
 * @author HP
 */
public class MyUnmarshaller_1 {
    public static Hrroles getDataFromXml() {
        File xmlFile = new File("D:\\XML\\Education\\hrroles.xml");

        
        Hrroles hrRoles = null;
        
        try {
            JAXBContext jc = JAXBContext.newInstance(Hrroles.class);
            Unmarshaller un = jc.createUnmarshaller();
            hrRoles = (Hrroles) un.unmarshal(xmlFile);
                     
        } catch (Exception je) {
            System.out.println(je.getMessage());
        }
        return hrRoles;
    }

}
