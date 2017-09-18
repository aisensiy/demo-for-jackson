package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class ResourceTest {
    @Autowired
    private JacksonTester<Resource<User>> json;
    private Resource<User> userResource;

    @Before
    public void setUp() throws Exception {
        User user = new User("123", "eisen", "xu");
        Link link = new Link(
            "self",
            UriComponentsBuilder.newInstance()
                .scheme("http").host("localhost")
                .path("/users/{id}")
                .buildAndExpand(user.getId()).toUri());
        userResource = new Resource<>(user, link);
    }

    @Test
    public void test() throws Exception {
        assertThat(json.write(userResource)).isEqualToJson("user_resource.json");
    }
}
