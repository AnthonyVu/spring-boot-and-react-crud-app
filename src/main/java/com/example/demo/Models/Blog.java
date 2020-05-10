package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Blog {
    private final UUID id;
    private final String title;
    private final String author;
    private final String url;
    private final Integer likes;

    public Blog(@JsonProperty("id") UUID id,
                @JsonProperty("title") String title,
                @JsonProperty("author") String author,
                @JsonProperty("url") String url,
                @JsonProperty("likes") Integer likes) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.url = url;
        this.likes = likes;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public Integer getLikes() {
        return likes;
    }
}
