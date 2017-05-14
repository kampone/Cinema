package com.epam.cinema.util

import com.epam.cinema.model.*
import com.epam.cinema.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

@Component
class InitialParams {

    @Autowired
    UserRepository userRepository

    @Autowired
    EventRepository eventRepository

    @Autowired
    TicketRepository ticketRepository

    @Autowired
    AuditoriumRepository auditoriumRepository

    @Autowired
    SeatRepository seatRepository


    @PostConstruct
    void createFakeUsers() {

        User user1 = new User(
                name: "Petya",
                birthDate: LocalDate.of(1992, 11, 12),
                password: 1234,
                enabled: true,
                email: "Petya@gmail.com",
                tickets: []
        )
        User user2 = new User(
                name: "Dzmitry",
                password: 1234,
                enabled: true,
                birthDate: LocalDate.of(1991, 6, 2),
                email: "Dzmitry@gmail.com",
                tickets: []
        )
        User user3 = new User(
                name: "Alex",
                password: 1234,
                enabled: true,
                birthDate: LocalDate.of(1989, 12, 1),
                email: "Alex@gmail.com",
                tickets: []
        )
        User user4 = new User(
                name: "Olga",
                password: 1234,
                enabled: true,
                birthDate: LocalDate.of(1995, 1, 22),
                email: "Olga@gmail.com",
                tickets: []
        )
        User user5 = new User(
                name: "Innokentiy",
                password: 1234,
                enabled: true,
                birthDate: LocalDate.of(1985, 3, 8),
                email: "Innokentiy@gmail.com",
                tickets: []
        )

        Event harryPotter = new Event(
                name: "Harry Potter",
                basePrice: 10,
                rating: Rating.MID,
                description: 'Harry Potter is a British-American film series based on the Harry Potter novels by author J. K. Rowling. ',
                pictureLink: 'http://az616578.vo.msecnd.net/files/2016/06/25/6360247867084148431991996925_hp.jpg'
        )

        Event titanic = new Event(
                name: "Titanic",
                basePrice: 8,
                rating: Rating.HIGH,
                description: "Titanic is a 1997 American epic romance-disaster film directed, written, co-produced, and co-edited by James Cameron.",
                pictureLink: "http://static.bbc.co.uk/history/img/ic/640/images/resources/histories/titanic.jpg"
        )



        Auditorium green = new Auditorium(
                name: "green",
                seats: [
                        new Seat(row: 1, place: 1, isVip: true),
                        new Seat(row: 1, place: 2, isVip: true),
                        new Seat(row: 1, place: 3, isVip: true),
                        new Seat(row: 1, place: 4, isVip: true),
                        new Seat(row: 1, place: 5, isVip: true),

                        new Seat(row: 2, place: 1, isVip: true),
                        new Seat(row: 2, place: 2, isVip: true),
                        new Seat(row: 2, place: 3, isVip: true),
                        new Seat(row: 2, place: 4, isVip: true),
                        new Seat(row: 2, place: 5, isVip: true),

                        new Seat(row: 3, place: 1, isVip: false),
                        new Seat(row: 3, place: 2, isVip: false),
                        new Seat(row: 3, place: 3, isVip: false),
                        new Seat(row: 3, place: 4, isVip: false),
                        new Seat(row: 3, place: 5, isVip: false),

                        new Seat(row: 4, place: 1, isVip: false),
                        new Seat(row: 4, place: 2, isVip: false),
                        new Seat(row: 4, place: 3, isVip: false),
                        new Seat(row: 4, place: 4, isVip: false),
                        new Seat(row: 4, place: 5, isVip: false),

                        new Seat(row: 5, place: 1, isVip: false),
                        new Seat(row: 5, place: 2, isVip: false),
                        new Seat(row: 5, place: 3, isVip: false),
                        new Seat(row: 5, place: 4, isVip: false),
                        new Seat(row: 5, place: 5, isVip: false),

                        new Seat(row: 6, place: 1, isVip: false),
                        new Seat(row: 6, place: 2, isVip: false),
                        new Seat(row: 6, place: 3, isVip: false),
                        new Seat(row: 6, place: 4, isVip: false),
                        new Seat(row: 6, place: 5, isVip: false)
                ]
        )


        Auditorium red = new Auditorium(
                name: "red",
                seats: [
                        new Seat(row: 1, place: 1, isVip: true),
                        new Seat(row: 1, place: 2, isVip: true),
                        new Seat(row: 1, place: 3, isVip: true),
                        new Seat(row: 1, place: 4, isVip: true),
                        new Seat(row: 1, place: 5, isVip: true),

                        new Seat(row: 2, place: 1, isVip: false),
                        new Seat(row: 2, place: 2, isVip: false),
                        new Seat(row: 2, place: 3, isVip: false),
                        new Seat(row: 2, place: 4, isVip: false),
                        new Seat(row: 2, place: 5, isVip: false),

                        new Seat(row: 3, place: 1, isVip: false),
                        new Seat(row: 3, place: 2, isVip: false),
                        new Seat(row: 3, place: 3, isVip: false),
                        new Seat(row: 3, place: 4, isVip: false),
                        new Seat(row: 3, place: 5, isVip: false),

                        new Seat(row: 4, place: 1, isVip: false),
                        new Seat(row: 4, place: 2, isVip: false),
                        new Seat(row: 4, place: 3, isVip: false),
                        new Seat(row: 4, place: 4, isVip: false),
                        new Seat(row: 4, place: 5, isVip: false),

                        new Seat(row: 5, place: 1, isVip: false),
                        new Seat(row: 5, place: 2, isVip: false),
                        new Seat(row: 5, place: 3, isVip: false),
                        new Seat(row: 5, place: 4, isVip: false),
                        new Seat(row: 5, place: 5, isVip: false),

                        new Seat(row: 6, place: 1, isVip: false),
                        new Seat(row: 6, place: 2, isVip: false),
                        new Seat(row: 6, place: 3, isVip: false),
                        new Seat(row: 6, place: 4, isVip: false),
                        new Seat(row: 6, place: 5, isVip: false)
                ]
        )


        [user1, user2, user3, user4, user5]*.each {
            userRepository.save it
        }

        [harryPotter, titanic]*.each {
            eventRepository.save it
        }

        [red, green]*.each {
            auditoriumRepository.save it
        }
        [green]*.each {
            createTicketsForAuditoriumAndEvent(it, harryPotter, LocalDateTime.of(2017, Month.AUGUST, 28, 12,30));
        }

        [red]*.each {
            createTicketsForAuditoriumAndEvent(it, titanic, LocalDateTime.of(2017, Month.AUGUST, 28, 12,30));
        }


    }

    def createTicketsForAuditoriumAndEvent(Auditorium auditorium, Event event, LocalDateTime dateTime){
        auditorium.seats.each {
            ticketRepository.save(new Ticket(
                    event: event,
                    user: null,
                    seat: it,
                    dateTime: dateTime,
                    isBooked: false
            ))
        }
    }
}
