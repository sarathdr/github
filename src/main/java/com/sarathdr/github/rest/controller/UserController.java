package com.sarathdr.github.rest.controller;

import com.sarathdr.github.model.Repo;
import com.sarathdr.github.util.UrlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Rest controller to handle user related apis
 */
@RestController
public class UserController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UrlBuilder urlBuilder;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Handles the api request to retrieve user's top 5 git repositories
     * Api {@code 'user/{git-handle}'} with parameter {@code type} values {@code all | owner | member}
     * @param handle the gitHub handle path variable
     * @param type the type parameter
     * @return the top 5 git repo
     */
    @RequestMapping("/user/{handle}")
    public Repo[] getUserRepos(
            @PathVariable final String handle,
            @RequestParam(value = "type", defaultValue = "owner") final String type
    ) {

        logger.info("Rendering repos for handle: " + handle);

        final Map<String, String> params = new HashMap<>();
        params.put("type", type);

        final Repo[] repos = restTemplate.getForObject(
                urlBuilder.getUserRepoUrl(handle),
                Repo[].class,
                params);

        logger.info("Got response size: " + repos.length);

        // Sort to get the top 5
        Arrays.sort(
                repos,
                (Repo a, Repo b) -> Integer.compare(b.getSize(), a.getSize())
        );

        // Get only top 5
        return repos.length > 5
                ? Arrays.copyOfRange(repos, 0, 5)
                : repos;
    }
}
