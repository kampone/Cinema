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

//TODO(convert birthdate)
    @RequestMapping("/registrate")
    public String registrate(@RequestParam String username, @RequestParam String password,
                             @RequestParam String email, @RequestParam String birthDate){
        User user = new User();

        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setBirthDate(LocalDate.now());
        userService.save(user);
        System.out.println(user);
        return "registration";
    }
}
