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
public class UserTest {

    @Autowired
    private JacksonTester<User> json;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("123", "eisen", "xu");
    }

    @Test
    public void should_serialize_json_property() throws Exception {
        assertThat(this.json.write(user)).isEqualToJson("user.json");
    }
}
