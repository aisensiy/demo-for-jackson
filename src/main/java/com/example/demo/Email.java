package com.example.demo;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public class Email {
    private String username;
    private String domain;

    public Email(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        String[] splits = value.split("@");
        if (splits.length != 2) {
            throw new IllegalArgumentException();
        }
        username = splits[0];
        domain = splits[1];
    }

    @JsonValue
    @Override
    public String toString() {
        return String.format("%s@%s", username, domain);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(username, email.username) &&
            Objects.equals(domain, email.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, domain);
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }
}
