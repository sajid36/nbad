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
public class User implements Serializable {
    
   
    private String userId;
    private String fName;
    private String lName;
    private String email;
    private Address address;
   
    
    public User() {
    }
    
    public User(String userId, String fName, String lName, String email, Address address) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.address = address;

    }
    
    public String getUserId() {
        return userId;
    }
    
    void setUserId() {
        this.userId = userId;
    }
    
    public String getFName() {
        return fName;
    }
    
    void setFName() {
        this.fName = fName;
    }
    
    public String getLName() {
        return lName;
    }
    
    void setLName() {
        this.lName = lName;
    }
    
    public String getEmail() {
        return email;
    }
    
    void setEmail() {
        this.email = email;
    }
    
    public Address getAddress() {
        return address;
    }
    
    void setAddress() {
        this.address = address;
    }
    
}
