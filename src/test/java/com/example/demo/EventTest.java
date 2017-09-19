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
public class EventTest {
    @Autowired
    private JacksonTester<Event> json;
    private UserCreatedEvent userCreatedEvent;
    private ArticleCreatedEvent articleCreatedEvent;

    @Before
    public void setUp() throws Exception {
        userCreatedEvent = new UserCreatedEvent();
        articleCreatedEvent = new ArticleCreatedEvent();
    }

    @Test
    public void serialize() throws Exception {
        assertThat(json.write(userCreatedEvent)).isEqualTo("user_created.json");

        assertThat(json.write(articleCreatedEvent)).isEqualTo("article_created.json");
    }

    @Test
    public void deserialize() throws Exception {
        String userCreatedContent = "{\n" +
            "  \"type\": \"user_created\"\n" +
            "}\n";
        assertThat(json.parse(userCreatedContent)).isInstanceOf(UserCreatedEvent.class);

        String articleCreatedContent = "{\n" +
            "  \"type\": \"article_created\"\n" +
            "}\n";
        assertThat(json.parse(articleCreatedContent)).isInstanceOf(ArticleCreatedEvent.class);
    }
}
