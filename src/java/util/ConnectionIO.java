/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author msajid
 */
import java.io.*;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.util.*;
import model.Connection;

public class ConnectionIO {

    public static String generateId(String filename) throws FileNotFoundException, IOException {
        String newId;
        try (BufferedReader inputStream = new BufferedReader(new FileReader(filename))) {
            newId = inputStream.readLine();
        }
        File file = new File(filename);
        try (FileWriter out = new FileWriter(file, false)) {
            out.write(String.valueOf(parseInt(newId) + 1));
        }
        return newId;

    }

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

    public static Connection getConnection(String id, String filename) throws IOException, ParseException {
        File file = new File(filename);
        Connection connection;
        try (BufferedReader in = new BufferedReader(
                new FileReader(file))) {
            connection = null;
            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String uniqueId = t.nextToken();
                if (uniqueId.equalsIgnoreCase(id)) {
                    String topic = t.nextToken();
                    String name = t.nextToken();
                    String host = t.nextToken();
                    String about = t.nextToken();
                    String location = t.nextToken();
                    String time = t.nextToken();
                    connection = new Connection(id, name, topic, about, location, time, host);

                }
                line = in.readLine();
            }
        }
        return connection;
    }

    public static ArrayList<Connection> getConnections(String filename) throws IOException, ParseException {
        ArrayList<Connection> connections = new ArrayList<>();
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
                    connections.add(connection);
                    line = in.readLine();
                } catch (NoSuchElementException e) {
                    line = in.readLine();
                }
            }
        }
        return connections;
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
