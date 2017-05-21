package com.epam.cinema.controller.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/registration")
    public String registrate(){
        return "registration";
    }

    @RequestMapping("/registrate")
    public String registrate(User user){
        userService.save(user);
        return "redirect:/";
    }
}
