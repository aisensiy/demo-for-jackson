package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RunWith(SpringRunner.class)
public class CamelExampleTest {
    @Autowired
    private JacksonTester<CamelExample> json;
    private CamelExample target;

    @Before
    public void setUp() throws Exception {
        target = new CamelExample("test");
    }

    @Test
    public void should_map_json_file() throws Exception {
        assertThat(json.write(target)).isEqualToJson("camel_example.json");
    }
}
