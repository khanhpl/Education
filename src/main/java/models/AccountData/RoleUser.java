/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.AccountData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@XmlRootElement(name="userrole")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoleUser {
    @XmlAttribute(name="id")
    private  String userroleID;
    @XmlAttribute(name = "userid")
    private String userID;
    @XmlAttribute(name = "roleid")
    private String roleID;

    public RoleUser() {
    }

    public RoleUser(String userroleID, String userID, String roleID) {
        this.userroleID = userroleID;
        this.userID = userID;
        this.roleID = roleID;
    }

    public String getUserroleID() {
        return userroleID;
    }

    public void setUserroleID(String userroleID) {
        this.userroleID = userroleID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "RoleUser{" + "userroleID=" + userroleID + ", userID=" + userID + ", roleID=" + roleID + '}';
    }
    
    
}
