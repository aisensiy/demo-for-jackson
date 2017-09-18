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
public class NormalJavaClassTest {
    @Autowired
    private JacksonTester<NormalJavaClass> json;
    private NormalJavaClass obj;

    @Before
    public void setUp() throws Exception {
        obj = new NormalJavaClass("aisensiy", 18);
    }

    @Test
    public void should_serialize_success() throws Exception {
        assertThat(this.json.write(obj)).isEqualTo("normaljavaclass.json");
    }
}
