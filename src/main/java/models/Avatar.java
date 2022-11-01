/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nhn19
 */
@XmlRootElement(name = "avatar")
@XmlAccessorType(XmlAccessType.FIELD)
public class Avatar {

    @XmlAttribute
    private String url;

    public Avatar() {
    }

    public Avatar(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Avatar{" + "url=" + url + '}';
    }
    
    
}
