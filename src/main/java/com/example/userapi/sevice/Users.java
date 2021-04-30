package com.example.userapi.sevice;

import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer userid;
    private String profilepicture;
    private String username;
    private String company;
    private String email;
    private String phone;

    Users() {
    }

    Users(String profilepicture, String username, String company, String email, String phone) {
        super();
        this.profilepicture = profilepicture;
        this.username = username;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return userid;
    }

    public String getProfilePicture() {
        return profilepicture;
    }

    public void setProfilePicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
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
