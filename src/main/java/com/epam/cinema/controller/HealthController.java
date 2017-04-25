package com.epam.cinema.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class HealthController {

    public HealthController() {
        System.out.println("============================================================================");
    }

    @RequestMapping("/")
    public String test(){
        return "Hello from webapp";
    }
}
