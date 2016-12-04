package com.sarathdr.github.util;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class UrlBuilder {

    @Value("${github.api.url}")
    private String baseUrl;

    public String getUserRepoUrl(final String handle) {
        return baseUrl + "/users/" + handle + "/repos";
    }
}
