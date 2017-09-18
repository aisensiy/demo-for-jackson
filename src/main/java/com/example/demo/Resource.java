package com.example.demo;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.util.Assert;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Resource<T> {
    private T content;

    private Map<String, URI> links = new TreeMap<>();

    public Resource(T content, Iterable<Link> links) {
        Assert.notNull(content, "Content must not be null!");
        this.content = content;
        this.add(links);
    }

    public Resource(T content, Link... links) {
        this.content = content;
        Arrays.stream(links).forEach(link -> {
            this.links.put(link.getRel(), link.getUri());
        });
    }

    @JsonUnwrapped
    public T getContent() {
        return content;
    }

    public void add(Link link) {
        Assert.notNull(link, "Link must not be null!");
        this.links.put(link.getRel(), link.getUri());
    }

    public void add(Iterable<Link> links) {
        Assert.notNull(links, "Given links must not be null!");
        for (Link candidate : links) {
            add(candidate);
        }
    }

    public Map<String, URI> getLinks() {
        return Collections.unmodifiableMap(links);
    }
}
