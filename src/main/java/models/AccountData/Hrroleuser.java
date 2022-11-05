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
@XmlRootElement(name = "userroles")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hrroleuser {
    
    @XmlElement(name = "userrole")
    private List<RoleUser> listRoleUser;

    public Hrroleuser() {
    }

    public Hrroleuser(List<RoleUser> listRoleUser) {
        this.listRoleUser = listRoleUser;
    }

    public List<RoleUser> getListRoleUser() {
        return listRoleUser;
    }

    public void setListRoleUser(List<RoleUser> listRoleUser) {
        this.listRoleUser = listRoleUser;
    }

    @Override
    public String toString() {
        return "Hrroleuser{" + "listRoleUser=" + listRoleUser + '}';
    }
    
    
}
