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
public class UserConnection implements Serializable {
    
    private String connectionId;
    private String rsvp;
    
    public UserConnection() {
    }
    
    public UserConnection(String connectionId, String rsvp) {
        this.connectionId = connectionId;
        this.rsvp = rsvp;

    }
    
    public String getConnectionId() {
        return connectionId;
    }
    
    void setConnectionId() {
        this.connectionId = connectionId;
    }
    
    public String getRsvp() {
        return rsvp;
    }
    
    void setRsvp() {
        this.rsvp = rsvp;
    }
}
