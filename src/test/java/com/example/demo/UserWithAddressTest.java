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
public class UserWithAddressTest {
    @Autowired
    private JacksonTester<UserWithAddress> json;
    private UserWithAddress user;

    @Before
    public void setUp() throws Exception {
        user = new UserWithAddress(
            "test",
            new Address("Beijing", "China"));

    }

    @Test
    public void test() throws Exception {
        assertThat(json.write(user)).isEqualToJson("user_with_address.json");
    }
}
