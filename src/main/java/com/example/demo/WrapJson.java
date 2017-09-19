package com.example.demo;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Objects;

@JsonRootName("wrap")
public class WrapJson {
    private String name;

    public WrapJson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private WrapJson() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapJson wrapJson = (WrapJson) o;
        return Objects.equals(name, wrapJson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
