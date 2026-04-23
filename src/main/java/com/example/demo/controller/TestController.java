package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.logging.log4j.util.Strings.concat;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/get")
    public String getValue (String s)
    {
        concat(s, "Kumar");
        return "Deepak".toLowerCase();
    }
}
