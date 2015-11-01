package com.vajda.jbehaveexample.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting/{name}")
    public String greeting(@PathVariable(value="name") String name) {
        String text = "world";
        if (name != null && !name.equals("")) {
            text = name;
        }
        return String.format(template, text);
    }
}
