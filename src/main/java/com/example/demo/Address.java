package com.example.demo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = AddressSerializer.class)
public class Address {
    private String City;
    private String Country;

    public Address(String city, String country) {
        City = city;
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }
}
