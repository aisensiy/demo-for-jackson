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
public class WrapJsonTest {
    @Autowired
    private JacksonTester<WrapJson> json;
    private WrapJson name;

    @Before
    public void setUp() throws Exception {
        name = new WrapJson("name");
    }

    @Test
    public void test() throws Exception {
        String content = "{\n" +
            "  \"wrap\": {\n" +
            "    \"name\": \"name\"\n" +
            "  }\n" +
            "}\n";
        assertThat(json.parseObject(content)).isEqualTo(name);
    }
}
