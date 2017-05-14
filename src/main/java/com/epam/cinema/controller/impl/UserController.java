package com.epam.cinema.controller.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users/{userId}")
    public String getUserInfo(@PathVariable Long userId, Model model){
        User user = userService.getById(userId);

        model.addAttribute("user", user);
        return "user";
    }


}
