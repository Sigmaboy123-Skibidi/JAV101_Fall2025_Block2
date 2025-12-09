package com.abcnews.entity;

import java.sql.Date;

public class User {
    private String id;
    private String password;
    private String fullname;
    private Date birthday;
    private Boolean gender;
    private String mobile;
    private String email;
    private Boolean role;

    public User() {}

    // Getter/Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }
    public Boolean getGender() { return gender; }
    public void setGender(Boolean gender) { this.gender = gender; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Boolean getRole() { return role; }
    public void setRole(Boolean role) { this.role = role; }
}
