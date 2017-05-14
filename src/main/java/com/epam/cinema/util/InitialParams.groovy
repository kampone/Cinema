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
                pictureLink: 'http://fm.cnbc.com/applications/cnbc.com/resources/img/editorial/2013/09/12/101029496--sites-default-files-images-101029496-3176173-1748009911-hp.jp-1.jpg'
        )

        Event titanic = new Event(
                name: "Titanic",
                basePrice: 8,
                rating: Rating.HIGH,
                description: "Titanic is a 1997 American epic romance-disaster film directed, written, co-produced, and co-edited by James Cameron.",
                pictureLink: "http://static.bbc.co.uk/history/img/ic/640/images/resources/histories/titanic.jpg"
        )

        Event toyStory = new Event(
                name: "Toy Story",
                basePrice: 9,
                rating: Rating.HIGH,
                description: "Toy Story is a 1995 American computer-animated buddy comedy adventure film produced by Pixar Animation Studios and released by Walt Disney Pictures.",
                pictureLink: "http://www.wetpaint.com/wp-content/uploads/2015/11/toy-story-20th-anniversary.jpg"
        )
        Event starWars = new Event(
                name: "Star Wars",
                basePrice: 12,
                rating: Rating.MID,
                description: "Star Wars is an American epic space opera franchise, centered on a film series created by George Lucas. It depicts the adventures of various characters \"a long time ago in a galaxy far, far away\".",
                pictureLink: "http://a.dilcdn.com/bl/wp-content/uploads/sites/6/2015/10/tfa_poster_wide_header-1536x864-959818851016.jpg"
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
                        new Seat(row: 1, place: 6, isVip: true),
                        new Seat(row: 1, place: 7, isVip: true),
                        new Seat(row: 1, place: 8, isVip: true),

                        new Seat(row: 2, place: 1, isVip: false),
                        new Seat(row: 2, place: 2, isVip: false),
                        new Seat(row: 2, place: 3, isVip: false),
                        new Seat(row: 2, place: 4, isVip: false),
                        new Seat(row: 2, place: 5, isVip: false),
                        new Seat(row: 2, place: 6, isVip: false),
                        new Seat(row: 2, place: 7, isVip: false),
                        new Seat(row: 2, place: 8, isVip: false),

                        new Seat(row: 3, place: 1, isVip: false),
                        new Seat(row: 3, place: 2, isVip: false),
                        new Seat(row: 3, place: 3, isVip: false),
                        new Seat(row: 3, place: 4, isVip: false),
                        new Seat(row: 3, place: 5, isVip: false),
                        new Seat(row: 3, place: 6, isVip: false),
                        new Seat(row: 3, place: 7, isVip: false),
                        new Seat(row: 3, place: 8, isVip: false),

                        new Seat(row: 4, place: 1, isVip: false),
                        new Seat(row: 4, place: 2, isVip: false),
                        new Seat(row: 4, place: 3, isVip: false),
                        new Seat(row: 4, place: 4, isVip: false),
                        new Seat(row: 4, place: 5, isVip: false),
                        new Seat(row: 4, place: 6, isVip: false),
                        new Seat(row: 4, place: 7, isVip: false),
                        new Seat(row: 4, place: 8, isVip: false),

                        new Seat(row: 5, place: 1, isVip: false),
                        new Seat(row: 5, place: 2, isVip: false),
                        new Seat(row: 5, place: 3, isVip: false),
                        new Seat(row: 5, place: 4, isVip: false),
                        new Seat(row: 5, place: 5, isVip: false),
                        new Seat(row: 5, place: 6, isVip: false),
                        new Seat(row: 5, place: 7, isVip: false),
                        new Seat(row: 5, place: 8, isVip: false),

                        new Seat(row: 6, place: 1, isVip: false),
                        new Seat(row: 6, place: 2, isVip: false),
                        new Seat(row: 6, place: 3, isVip: false),
                        new Seat(row: 6, place: 4, isVip: false),
                        new Seat(row: 6, place: 5, isVip: false),
                        new Seat(row: 6, place: 6, isVip: false),
                        new Seat(row: 6, place: 7, isVip: false),
                        new Seat(row: 6, place: 8, isVip: false)
                ]
        )


        [user1, user2, user3, user4, user5]*.each {
            userRepository.save it
        }

        [harryPotter, titanic, toyStory, starWars]*.each {
            eventRepository.save it
        }

        [red, green]*.each {
            auditoriumRepository.save it
        }
        [green]*.each {
            createTicketsForAuditoriumAndEvent(it, harryPotter, LocalDateTime.of(2017, Month.AUGUST, 28, 12,30));
            createTicketsForAuditoriumAndEvent(it, starWars, LocalDateTime.of(2017, Month.AUGUST, 26, 12,30));
        }

        [red]*.each {
            createTicketsForAuditoriumAndEvent(it, titanic, LocalDateTime.of(2017, Month.AUGUST, 29, 12,30));
            createTicketsForAuditoriumAndEvent(it, toyStory, LocalDateTime.of(2017, Month.AUGUST, 27, 12,30));
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
