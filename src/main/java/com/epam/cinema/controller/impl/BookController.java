package com.epam.cinema.controller.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.service.BookingService;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.TicketService;
import com.epam.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class BookController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/unbook/{id}", method = RequestMethod.GET)
    public String unbookTicket(@PathVariable Long id, HttpSession session, Model model) {
        ticketService.unbookTicketWithId(id);
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.getById(userId);
        model.addAttribute("user", user);

        return "user";
    }
}
