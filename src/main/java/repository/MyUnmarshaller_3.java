/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import models.AccountData.Hrroleuser;

/**
 *
 * @author HP
 */
public class MyUnmarshaller_3 {
    public static Hrroleuser getDataFromXml() {
        // bỏ đường dẫn tới file xml
        File xmlFile = new File("C:\\Users\\HP\\OneDrive\\Desktop\\Education\\hrroleuser.xml");

        
        Hrroleuser hrroleuser = null;
        
        try {
            JAXBContext jc = JAXBContext.newInstance(Hrroleuser.class);
            Unmarshaller un = jc.createUnmarshaller();
            hrroleuser = (Hrroleuser) un.unmarshal(xmlFile);
                     
        } catch (Exception je) {
            System.out.println(je.getMessage());
        }
        return hrroleuser;
    }
}
