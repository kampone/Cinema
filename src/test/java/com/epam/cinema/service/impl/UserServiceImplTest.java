package com.epam.cinema.service.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.repository.AuthorityRepository;
import com.epam.cinema.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private AuthorityRepository authorityRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("name");

        userService.save(user);

        Mockito.verify(userRepository).saveUser(user);
        Mockito.verify(authorityRepository).assignUser(user.getName());
    }

    @Test
    public void remove() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("name");

        userService.remove(user);

        Mockito.verify(userRepository).removeUser(user);
    }

    @Test
    public void getById() throws Exception {
        Long id = 1L;

        userService.getById(id);

        Mockito.verify(userRepository).getUserById(id);
    }

    @Test
    public void getByEmail() throws Exception {
        String email = "email";

        userService.getByEmail(email);

        Mockito.verify(userRepository).getUserByEmail(email);
    }

    @Test
    public void getAll() throws Exception {
        userService.getAll();

        Mockito.verify(userRepository).getAllUser();
    }

    @Test
    public void isAdmin() throws Exception {
        String username = "username";

        userService.isAdmin(username);

        Mockito.verify(authorityRepository).getAuthority(username);
    }

}