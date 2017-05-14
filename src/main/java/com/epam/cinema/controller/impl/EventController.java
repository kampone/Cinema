package com.epam.cinema.controller.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String getAllEvents(Model model, HttpSession session){
        String username = ((User) ((SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal()).getUsername();
        Long id = userService.getAll().stream().filter(user -> user.getName().equals(username)).findFirst().get().getId();
        boolean admin = userService.isAdmin(username);
        session.setAttribute("userId", id);
        session.setAttribute("isAdmin", admin);
        List<Event> events = eventService.getAll();
        model.addAttribute("events", events);
        return "index";
    }

    @RequestMapping("/events/{eventId}")
    public String getAllEvents(@PathVariable Long eventId, Model model){
        Event event = eventService.getById(eventId);
        model.addAttribute("event", event);

        return "event";
    }

    @GetMapping("/addevent")
    public String addEventForm(){
        return "addevent";
    }

    @PostMapping("/events")
    public String addEvent(Event event, Model model){
        model.addAttribute("event", event);
        eventService.save(event);
        return "redirect:/";
    }

    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        eventService.remove(id);
        return "redirect:/";
    }
}
