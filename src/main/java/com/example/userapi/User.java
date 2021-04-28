package com.example.userapi;

import javax.swing.*;

public class User {
    private int id;
    private String profilePicture;
    private String name;
    private String company;
    private String email;
    private String phone;

    public User(int id, String profilePicture, String name, String company, String email, String phone) {
        this.id = id;
        this.profilePicture = profilePicture;
        this.name = name;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
