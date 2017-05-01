package com.epam.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller("/test")
public class HealthController {

    public HealthController() {
        System.out.println("============================================================================");
    }

    @RequestMapping("/")
    public String test(){
        return "hello";
    }
}
