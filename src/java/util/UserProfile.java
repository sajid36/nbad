/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import model.Address;
import model.Connection;
import model.User;
import model.UserConnection;

/**
 *
 * @author sajid
 */

public class UserProfile {

    public static ArrayList<UserConnection> addConnection(String connectionId, String rsvp, Connection connection, ArrayList<UserConnection> userConnections){
        UserConnection userConnection = new UserConnection();
        userConnection.setConnectionId(connectionId);
        userConnection.setRsvp(rsvp);
        userConnection.setEventName(connection.getName());
        userConnection.setCategory(connection.getTopic());
        userConnections.add(userConnection);
        
        return userConnections;
    }
    
    public static ArrayList<UserConnection> updateConnection(String connectionId, String rsvp, ArrayList<UserConnection> userConnections) {
        for (int i = 0; i < userConnections.size(); i++) {
            if(userConnections.get(i).getConnectionId().equalsIgnoreCase(connectionId)){
                userConnections.get(i).setRsvp(rsvp);
            }
       }
        
        return userConnections;
    }
    
    public static ArrayList<UserConnection> removeConnection(String connectionId, ArrayList<UserConnection> userConnections) {
        for (int i = 0; i < userConnections.size(); i++) {
            if(userConnections.get(i).getConnectionId().equalsIgnoreCase(connectionId)){
                userConnections.remove(i);
            }
       }
        return userConnections;
    }
    
    public static void printCurrentList(ArrayList<UserConnection> userConnections) {
        for (int i = 0; i < userConnections.size(); i++) {
            System.out.println("Current ids: "+userConnections.get(i).getConnectionId());
       }
    }
    
    public static ArrayList<UserConnection> getUserConnections (HttpSession session) {
        ArrayList<UserConnection> userConnections = (ArrayList<UserConnection>) session.getAttribute("userConnections");
        //printCurrentList(userConnections);
        return userConnections;
    }
    
    public static boolean duplicateCheck (ArrayList<UserConnection> userConnections, String connectionId) {
        boolean dup = false;
        for (int i = 0; i < userConnections.size(); i++) {
            if(userConnections.get(i).getConnectionId().equalsIgnoreCase(connectionId)){
                dup = true;
            }
       }
        return dup;
    }
    
    public static User getPopulatedUser(String email) throws ParseException {
        User user = null;
        Address address;
        String userId = "1";
        String fName = "Md";
        String lName = "Sajid";
        String addressField1 = "9625 Vinca Cir";
        String addressField2 = "Apt E";
        String city = "Charlotte";
        String state = "NC";
        String zip = "28213";
        String country = "USA";
        address = new Address (addressField1, addressField2, city, state, zip, country);
        user = new User(userId, fName, lName, email, address);
        return user;
    }
}
