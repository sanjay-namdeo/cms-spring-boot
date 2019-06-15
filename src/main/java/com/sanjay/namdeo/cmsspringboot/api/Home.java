package com.sanjay.namdeo.cmsspringboot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping
    public String home() {
        return "Welcome to this application" +
                "";
    }
}
