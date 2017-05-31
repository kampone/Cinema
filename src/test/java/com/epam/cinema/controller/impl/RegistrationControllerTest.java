package com.epam.cinema.controller.impl;

import com.epam.cinema.model.User;
import com.epam.cinema.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class RegistrationControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private RegistrationController registrationController;

    @Test
    public void registrate() throws Exception {
        String page = registrationController.registrate();

        assertEquals("registration", page);
    }

    @Test
    public void registrate_withUser() throws Exception {
        User user = new User();

        String page = registrationController.registrate(user);

        verify(userService).save(user);
        assertEquals("redirect:/", page);
    }

}