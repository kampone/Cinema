package com.epam.cinema.controller.impl;

import com.epam.cinema.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private UserController userController;

    @Test
    public void getUserInfo() throws Exception {
        Long id = 1L;

        String page = userController.getUserInfo(id, model);

        verify(userService).getById(id);
        verify(model).addAttribute(anyString(), anyObject());
        assertEquals("user", page);
    }

}