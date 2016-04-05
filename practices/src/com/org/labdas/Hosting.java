package com.org.labdas;

import java.util.Date;

/**
 * Created by STO on 31/03/2016.
 */
public class Hosting {

    private int Id;
    private String name;
    private Date createdDate;

    public Hosting(int id, String name, Date createdDate) {
        setId(id);
        this.setName(name);
        this.setCreatedDate(createdDate);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    //getters and setters
}