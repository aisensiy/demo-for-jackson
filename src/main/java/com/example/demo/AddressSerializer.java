package com.example.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class AddressSerializer extends StdSerializer<Address> {

    public AddressSerializer() {
        this(Address.class);
    }

    public AddressSerializer(Class<Address> t) {
        super(t);
    }

    @Override
    public void serialize(Address value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(String.format("%s, %s", value.getCity(), value.getCountry()));
    }
}
