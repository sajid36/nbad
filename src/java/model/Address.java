/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author sajid
 */
public class Address implements Serializable {
    
    private String addressField1;
    private String addressField2;
    private String city;
    private String state;
    private String zip;
    private String country;
    
    public Address() {

    }
    public Address(String addressField1, String addressField2, String city, String state, String zip, String country) {
        this.addressField1 = addressField1;
        this.addressField2 = addressField2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
    
    public String getAddressField1() {
        return addressField1;
    }
    
    void setAddressField1() {
        this.addressField1 = addressField1;
    }
    
    public String getAddressField2() {
        return addressField2;
    }
    
    void setAddressField2() {
        this.addressField2 = addressField2;
    }
    
    public String getCity() {
        return city;
    }
    
    void setCity() {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    void setState() {
        this.state = state;
    }
    
    public String getZip() {
        return zip;
    }
    
    void setZip() {
        this.zip = zip;
    }
    
    public String getCountry() {
        return country;
    }
    
    void setCountry() {
        this.country = country;
    }
}
