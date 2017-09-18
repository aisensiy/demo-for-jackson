package com.example.demo;

import java.net.URI;

public class Link {
    private String rel;
    private URI uri;

    public Link(String rel, URI uri) {
        this.rel = rel;
        this.uri = uri;
    }

    public String getRel() {
        return rel;
    }

    public URI getUri() {
        return uri;
    }
}
