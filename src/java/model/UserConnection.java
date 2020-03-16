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
    private String eventName;
    private String category;
    
    public UserConnection() {
    }
    
    public UserConnection(String connectionId, String rsvp, String eventName, String category) {
        this.connectionId = connectionId;
        this.rsvp = rsvp;
        this.eventName = eventName;
        this.category = category;

    }
    
    public String getConnectionId() {
        return connectionId;
    }
    
    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }
    
    public String getRsvp() {
        return rsvp;
    }
    
    public void setRsvp(String rsvp) {
        this.rsvp = rsvp;
    }
    
    public String getEventName() {
        return eventName;
    }
    
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}
