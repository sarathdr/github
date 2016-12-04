package com.sarathdr.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by sarathdr on 03/12/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo {

    private long id;
    private String name;
    private String fullName;
    private int size;
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
