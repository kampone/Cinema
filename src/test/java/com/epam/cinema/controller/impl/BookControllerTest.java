package com.epam.cinema.controller.impl;

import com.epam.cinema.service.TicketService;
import com.epam.cinema.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class BookControllerTest {

    @Mock
    private TicketService ticketService;

    @Mock
    private UserService userService;

    @Mock
    private HttpSession session;

    @Mock
    private Model model;

    @InjectMocks
    private BookController bookController;

    @Test
    public void unbookTicket() throws Exception {
        Long id = 1L;

        bookController.unbookTicket(id, session, model);

        verify(session).getAttribute("userId");
        verify(ticketService).unbookTicketWithId(anyLong(), anyLong());
        verify(userService).getById(anyLong());
        verify(model).addAttribute(anyString(), anyObject());
    }

}