/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.AccountData;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@XmlRootElement(name = "roles")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hrroles {
    @XmlElement(name = "role")
    private List<Role> listRole;

    public Hrroles() {
    }

    public Hrroles(List<Role> listRole) {
        this.listRole = listRole;
    }

    public List<Role> getListRole() {
        return listRole;
    }

    public void setListRole(List<Role> listRole) {
        this.listRole = listRole;
    }

    @Override
    public String toString() {
        return "Hrroles{" + "listRole=" + listRole + '}';
    }
    
}
