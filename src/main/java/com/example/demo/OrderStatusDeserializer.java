package com.example.demo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class OrderStatusDeserializer extends StdDeserializer<OrderStatus> {
    public OrderStatusDeserializer(Class<?> vc) {
        super(vc);
    }

    public OrderStatusDeserializer() {
        super(OrderStatus.class);
    }

    @Override
    public OrderStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return OrderStatus.valueOf(p.getText().toUpperCase());
    }
}
