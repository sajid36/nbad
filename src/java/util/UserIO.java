/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import model.Address;
import model.Connection;
import model.User;
import model.UserConnection;

/**
 *
 * @author sajid
 */

public class UserIO {

    public static void addRecord(Connection connection, String filename) throws IOException {
        File file = new File(filename);
        try (PrintWriter out = new PrintWriter(
                new FileWriter(file, true))) {
            out.println(connection.getId() + "|"
                    + connection.getTopic() + "|"
                    + connection.getName() + "|"
                    + connection.getHost() + "|"
                    + connection.getDesc() + "|"
                    + connection.getLocation() + "|"
                    + connection.getTime()
            );
        }
    }
    
    public static Address getAddress(String userId, String filename2) throws IOException, ParseException {
        File file = new File(filename2);
        Address address;
        try (BufferedReader in = new BufferedReader(
                new FileReader(file))) {
            address = null;
            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String uniqueId = t.nextToken();
                if (uniqueId.equalsIgnoreCase(userId)) {
                    String addressField1 = t.nextToken();
                    String addressField2 = t.nextToken();
                    String city = t.nextToken();
                    String state = t.nextToken();
                    String zip = t.nextToken();
                    String country = t.nextToken();
                    address = new Address(addressField1, addressField2, city, state, zip, country);

                }
                line = in.readLine();
            }
        }
        return address;
        
    }
    
    public static User getUser(String email, String filename, String filename2) throws IOException, ParseException {
        File file = new File(filename);
        User user;
        try (BufferedReader in = new BufferedReader(
                new FileReader(file))) {
            user = null;
            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String uniqueEmail = t.nextToken();
                if (uniqueEmail.equalsIgnoreCase(email)) {
                    String id = t.nextToken();
                    String fName = t.nextToken();
                    String lName = t.nextToken();
                    Address address = getAddress(id, filename2);
                    user = new User(id, fName, lName, email, address);
                }
                line = in.readLine();
            }
        }
        return user;
    }

    public static ArrayList<UserConnection> getUserConnections (String userId, String filename) throws IOException, ParseException {
        ArrayList<UserConnection> userConnections = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(filename))) {
            String line = in.readLine();
            while (line != null) {
                try {
                    StringTokenizer t = new StringTokenizer(line, "|");
                    String uniqueUserId = t.nextToken();
                    if (uniqueUserId.equalsIgnoreCase(userId)) {
                        String connectionId = t.nextToken();
                        String rsvp = t.nextToken();
                        UserConnection userConnection = new UserConnection(connectionId, rsvp);
                        userConnections.add(userConnection);
                    }
                    line = in.readLine();
                } catch (NoSuchElementException e) {
                    line = in.readLine();
                }
            }
        }
        return userConnections;
    }

    public static HashMap<String, Connection> getConnectionsMap(String filename) throws IOException, ParseException {
        HashMap<String, Connection> connections = new HashMap<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(filename))) {
            String line = in.readLine();
            while (line != null) {
                try {
                    StringTokenizer t = new StringTokenizer(line, "|");
                    String id = t.nextToken();
                    String topic = t.nextToken();
                    String name = t.nextToken();
                    String host = t.nextToken();
                    String about = t.nextToken();
                    String location = t.nextToken();
                    String time = t.nextToken();
                    Connection connection = new Connection(id, name, topic, about, location, time, host);
                    connections.put(id, connection);
                    line = in.readLine();
                } catch (NoSuchElementException e) {
                    line = in.readLine();
                }
            }
        }
        return connections;
    }
}
