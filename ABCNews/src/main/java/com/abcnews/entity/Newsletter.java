package com.abcnews.entity;

public class Newsletter {
    private int id;
    private String email;

    public Newsletter() {}

    public Newsletter(String email) {
        this.email = email;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
