package com.example.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class OrderStatusSerializer extends StdSerializer<OrderStatus> {
    public OrderStatusSerializer(Class<OrderStatus> t) {
        super(t);
    }

    public OrderStatusSerializer() {
        super(OrderStatus.class);
    }

    @Override
    public void serialize(OrderStatus value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString().toLowerCase());
    }
}
