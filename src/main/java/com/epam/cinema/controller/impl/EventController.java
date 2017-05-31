package com.epam.cinema.controller.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.service.AuditoriumService;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

//import com.epam.cinema.util.InitialParams;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuditoriumService auditoriumService;

    @RequestMapping("/")
    public String getAllEvents(Model model, HttpSession session) {
        String username = "admin";//= getUserName(session);
        Long id = userService.getAll().stream().filter(user -> user.getName().equals(username)).findFirst().orElse(new com.epam.cinema.model.User()).getId();
        boolean admin = userService.isAdmin(username);
        session.setAttribute("userId", id);
        session.setAttribute("isAdmin", admin);
        List<Event> events = eventService.getAll();
        model.addAttribute("events", events);
        return "index";
    }


    @RequestMapping("/events/{eventId}")
    public String getAllEvents(@PathVariable Long eventId, Model model) {
        Event event = eventService.getById(eventId);
        model.addAttribute("event", event);

        return "event";
    }

    @GetMapping("/addevent")
    public String addEventForm() {
        return "addevent";
    }

    @PostMapping("/events")
    public String addEvent(Event event, Model model) {
        model.addAttribute("event", event);
        eventService.save(event);
        return "redirect:/";
    }

    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/events")
    public String deleteEvent(@RequestParam("name") String name, Model model) {
        Event event = eventService.getByName(name);
        model.addAttribute("events", Arrays.asList(event));
        return "index";
    }
//
//    private String getUserName(HttpSession session) {
//        return ((User) ((SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT")).getAuthentication().getPrincipal()).getUsername();
//    }
}
