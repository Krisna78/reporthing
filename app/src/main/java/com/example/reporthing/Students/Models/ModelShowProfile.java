package com.example.reporthing.Students.Models;

public class ModelShowProfile {
    public String id,username,password;

    public ModelShowProfile(String id, String password, String username) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
