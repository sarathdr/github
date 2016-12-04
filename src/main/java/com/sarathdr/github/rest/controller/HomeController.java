package com.sarathdr.github.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sarathdr on 03/12/2016.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Welcome to Github Apis";
    }
}
