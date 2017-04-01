package com.epam.cinema.util

import com.epam.cinema.model.Auditorium
import com.epam.cinema.model.Event
import com.epam.cinema.model.Rating
import com.epam.cinema.model.Seat
import com.epam.cinema.model.Ticket
import com.epam.cinema.model.User
import com.epam.cinema.service.EventService
import com.epam.cinema.service.TicketService
import com.epam.cinema.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct
import java.sql.Date
import java.time.LocalDate
import java.time.LocalDateTime


@Component
class InitialParams {

    @Autowired
    UserService userService

    @Autowired
    EventService eventService

    @Autowired
    TicketService ticketService


    @PostConstruct
    @Newify([User, Event, Seat, Auditorium, Ticket])
    void createFakeUsers() {

        User user1 = User(
                id: 1,
                name: "Petya",
                birthDate: LocalDate.of(1992, 11, 12),
                email: "Petya@gmail.com",
                tickets: []
        )
        User user2 = User(
                id: 2,
                name: "Dzmitry",
                birthDate: LocalDate.of(1991, 6, 2),
                email: "Dzmitry@gmail.com",
                tickets: []
        )
        User user3 = User(
                id: 3,
                name: "Alex",
                birthDate: LocalDate.of(1989, 12, 1),
                email: "Alex@gmail.com",
                tickets: []
        )
        User user4 = User(
                id: 4,
                name: "Olga",
                birthDate: LocalDate.of(1995, 1, 22),
                email: "Olga@gmail.com",
                tickets: []
        )
        User user5 = User(
                id: 5,
                name: "Innokentiy",
                birthDate: LocalDate.of(1985, 3, 8),
                email: "Innokentiy@gmail.com",
                tickets: []
        )

        Event harryPotter = Event(
                id: 1,
                name: "Harry Potter",
                basePrice: 10,
                rating: Rating.MID
        )

        Event titanic = Event(
                id: 2,
                name: "Titanic",
                basePrice: 8,
                rating: Rating.HIGH
        )

        Date.valueOf(LocalDateTime.now())
        Auditorium green = Auditorium(
                name: "green",
                seats: [
                        Seat(row: 1, place: 1, isVip: true),
                        Seat(row: 1, place: 2, isVip: true),
                        Seat(row: 1, place: 3, isVip: true),
                        Seat(row: 1, place: 4, isVip: true),
                        Seat(row: 1, place: 5, isVip: true),

                        Seat(row: 2, place: 1, isVip: true),
                        Seat(row: 2, place: 2, isVip: true),
                        Seat(row: 2, place: 3, isVip: true),
                        Seat(row: 2, place: 4, isVip: true),
                        Seat(row: 2, place: 5, isVip: true),

                        Seat(row: 3, place: 1, isVip: false),
                        Seat(row: 3, place: 2, isVip: false),
                        Seat(row: 3, place: 3, isVip: false),
                        Seat(row: 3, place: 4, isVip: false),
                        Seat(row: 3, place: 5, isVip: false),

                        Seat(row: 4, place: 1, isVip: false),
                        Seat(row: 4, place: 2, isVip: false),
                        Seat(row: 4, place: 3, isVip: false),
                        Seat(row: 4, place: 4, isVip: false),
                        Seat(row: 4, place: 5, isVip: false),

                        Seat(row: 5, place: 1, isVip: false),
                        Seat(row: 5, place: 2, isVip: false),
                        Seat(row: 5, place: 3, isVip: false),
                        Seat(row: 5, place: 4, isVip: false),
                        Seat(row: 5, place: 5, isVip: false),

                        Seat(row: 6, place: 1, isVip: false),
                        Seat(row: 6, place: 2, isVip: false),
                        Seat(row: 6, place: 3, isVip: false),
                        Seat(row: 6, place: 4, isVip: false),
                        Seat(row: 6, place: 5, isVip: false)
                ]
        )


        Auditorium red = Auditorium(
                name: "red",
                seats: [
                        Seat(row: 1, place: 1, isVip: true),
                        Seat(row: 1, place: 2, isVip: true),
                        Seat(row: 1, place: 3, isVip: true),
                        Seat(row: 1, place: 4, isVip: true),
                        Seat(row: 1, place: 5, isVip: true),

                        Seat(row: 2, place: 1, isVip: false),
                        Seat(row: 2, place: 2, isVip: false),
                        Seat(row: 2, place: 3, isVip: false),
                        Seat(row: 2, place: 4, isVip: false),
                        Seat(row: 2, place: 5, isVip: false),

                        Seat(row: 3, place: 1, isVip: false),
                        Seat(row: 3, place: 2, isVip: false),
                        Seat(row: 3, place: 3, isVip: false),
                        Seat(row: 3, place: 4, isVip: false),
                        Seat(row: 3, place: 5, isVip: false),

                        Seat(row: 4, place: 1, isVip: false),
                        Seat(row: 4, place: 2, isVip: false),
                        Seat(row: 4, place: 3, isVip: false),
                        Seat(row: 4, place: 4, isVip: false),
                        Seat(row: 4, place: 5, isVip: false),

                        Seat(row: 5, place: 1, isVip: false),
                        Seat(row: 5, place: 2, isVip: false),
                        Seat(row: 5, place: 3, isVip: false),
                        Seat(row: 5, place: 4, isVip: false),
                        Seat(row: 5, place: 5, isVip: false),

                        Seat(row: 6, place: 1, isVip: false),
                        Seat(row: 6, place: 2, isVip: false),
                        Seat(row: 6, place: 3, isVip: false),
                        Seat(row: 6, place: 4, isVip: false),
                        Seat(row: 6, place: 5, isVip: false)
                ]
        )

        [user1, user2, user3, user4, user5]*.each {
            userService.save it
        }

        [harryPotter, titanic]*.each {
            eventService.save it
        }

        green.seats.each {
            seatService.save it
        }

        red.seats.each {
            seatService.save it
        }

        [green, red]*.each {
            auditoriumService.save it
        }

        int userId = 0

        red.seats*.each {

            ticketService.save Ticket(
                    id: ++userId,
                    dateTime: LocalDateTime.now().plusDays(12),
                    event: harryPotter,
                    booked: false,
                    seat: it
            )

        }

    }
}
