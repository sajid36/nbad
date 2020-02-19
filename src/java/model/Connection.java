/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author msajid
 */
public class Connection implements Serializable {

    private String id;
    private String name;
    private String topic;
    private String host;
    private String desc;
    private String location;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private String time;

    public Connection() {

    }

    public Connection(String id, String name, String topic, String desc, String location, String time, String host) throws ParseException {
        this.desc = desc;
        this.id = id;
        this.location = location;
        this.name = name;
        this.time = time;
        this.topic = topic;
        this.host = host;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) throws ParseException {
        this.time = time;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private Date convertToDate(String stringTime) throws ParseException {
        Date dateTime;
        dateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(stringTime);
        return dateTime;
    }

}
