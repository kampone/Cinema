package com.epam.cinema.controller.impl;

import com.epam.cinema.model.Event;
import com.epam.cinema.service.AuditoriumService;
import com.epam.cinema.service.EventService;
import com.epam.cinema.service.UserService;
import com.epam.cinema.util.InitialParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private InitialParams initialParams;

    @RequestMapping("/")
    public String getAllEvents(Model model, HttpSession session) {
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
        initialParams.createTicketsForAuditoriumAndEvent(auditoriumService.getByName("green"), event, LocalDateTime.of(2017, Month.AUGUST, 26, 12, 30));
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
}
