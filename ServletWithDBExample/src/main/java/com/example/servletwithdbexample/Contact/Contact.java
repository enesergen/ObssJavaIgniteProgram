package com.example.servletwithdbexample.Contact;

public class Contact {
    private int id;
    private String name;
    private String telnumber;

    public Contact(int id, String name, String telnumber) {
        this.id = id;
        this.name = name;
        this.telnumber = telnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }
}
