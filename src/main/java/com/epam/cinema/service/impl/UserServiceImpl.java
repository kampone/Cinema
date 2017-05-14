package com.epam.cinema.service.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.repository.AuthorityRepository;
import com.epam.cinema.repository.UserRepository;
import com.epam.cinema.service.AuditoriumService;
import com.epam.cinema.service.TicketService;
import com.epam.cinema.service.UserService;

import java.util.Set;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private TicketService ticketService;

    public UserServiceImpl(UserRepository repository, TicketService ticketService, AuthorityRepository authorityRepository) {
        this.userRepository = repository;
        this.ticketService = ticketService;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
        authorityRepository.assignUser(user.getName());
    }

    @Override
    public void remove(User user) {
        userRepository.remove(user);
    }

    @Override
    public User getById(Long id) {
        User user = userRepository.getById(id);
        user.setTickets(ticketService.getTicketsForUser(id));
        return user;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public Set<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public boolean isAdmin(String username){
        return authorityRepository.getAuthority(username).equals("admin");
    }
}
