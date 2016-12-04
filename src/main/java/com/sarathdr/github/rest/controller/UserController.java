package com.sarathdr.github.rest.controller;

import com.sarathdr.github.model.Repo;
import com.sarathdr.github.model.RepoList;
import com.sarathdr.github.util.UrlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
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

    @RequestMapping("/user/{handle}")
    public Repo[] getUserRepos(
            @PathVariable final String handle,
            @RequestParam(value = "type", defaultValue = "owner") final String type
    ) {

        logger.info("Rendering repos for handle: " + handle);

        final Map<String, String> params = new HashMap<>();
        params.put("type", type);

        return restTemplate.getForObject(
                urlBuilder.getUserRepoUrl(handle),
                Repo[].class,
                params);
    }
}
