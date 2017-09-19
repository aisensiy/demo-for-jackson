package com.example.demo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = UserCreatedEvent.class, name = "user_created"),
    @JsonSubTypes.Type(value = ArticleCreatedEvent.class, name = "article_created")
})
public abstract class Event {
}

@JsonTypeName("user_created")
class UserCreatedEvent extends Event {

}

@JsonTypeName("article_created")
class ArticleCreatedEvent extends Event {

}
