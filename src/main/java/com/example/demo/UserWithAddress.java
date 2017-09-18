package com.example.demo;

public class UserWithAddress {
    private String username;
    private Address address;

    public UserWithAddress(String username, Address address) {
        this.username = username;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public Address getAddress() {
        return address;
    }
}
