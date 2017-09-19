package com.example.demo;

import java.util.Objects;

public class OrderWithStatus {
    private OrderStatus status;
    private String id;

    public OrderWithStatus(String id, OrderStatus status) {
        this.status = status;
        this.id = id;
    }

    private OrderWithStatus() {

    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderWithStatus that = (OrderWithStatus) o;
        return status == that.status &&
            Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, id);
    }
}
