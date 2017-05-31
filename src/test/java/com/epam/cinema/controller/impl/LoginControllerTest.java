package com.epam.cinema.controller.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Test
    public void login() throws Exception {
        String login = loginController.login();

        assertEquals("login", login);
    }

}