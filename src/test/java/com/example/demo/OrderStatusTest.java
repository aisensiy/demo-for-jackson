package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class OrderStatusTest {
    @Autowired
    private JacksonTester<OrderWithStatus> json;
    private OrderWithStatus order;

    @Before
    public void setUp() throws Exception {
        order = new OrderWithStatus("123", OrderStatus.UNPAID);
    }

    @Test
    public void test_serialize() throws Exception {
        assertThat(json.write(order)).isEqualTo("order.json");
    }

    @Test
    public void test_deserialize() throws Exception {
        String content = "{\"status\": \"unpaid\", \"id\": \"123\"}";

        assertThat(json.parse(content)).isEqualTo(order);
    }
}
