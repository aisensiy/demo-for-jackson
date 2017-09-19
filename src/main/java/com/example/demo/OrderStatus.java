package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    UNPAID, PREPARING, COMPLETED, CANCELED;

    @JsonCreator
    public static OrderStatus fromValue(@JsonProperty("status") String value) {
        return valueOf(value.toUpperCase());
    }

    @JsonValue
    public String ofValue() {
        return this.toString().toLowerCase();
    }
}
