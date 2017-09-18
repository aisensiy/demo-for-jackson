package com.example.demo;

public class UserWithEmail {
    private String username;
    private Email email;

    public UserWithEmail(String username, Email email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }
}
