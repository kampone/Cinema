package com.epam.cinema.handler;

import com.epam.cinema.model.Auditorium;
import com.epam.cinema.model.Seat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Objects;

@Configuration(value = "handler")
@PropertySource("classpath:auditorium.properties")
public class AuditoriumHandler {

    @Value("${auditorium.star.name}")
    private String starName;

    @Value("${auditorium.star.rows}")
    private Integer rowsString;

    @Value("${auditorium.star.seats}")
    private Integer seats;

    @Value("${auditorium.star.vip.row}")
    private Integer vipRow;

    @Value("${auditorium.star.vip.seats.min}")
    private Integer minVipPlace;

    @Value("${auditorium.star.vip.seats.max}")
    private Integer maxVipPlace;

    public Auditorium starAuditorium(){
        Integer rows = Integer.valueOf(rowsString);
        Auditorium auditorium = new Auditorium();
        auditorium.setName(starName);
        ArrayList<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= rows ; row++) {
            for (int place = 1; place <= this.seats; place++) {
//                Seat seat = new Seat(row, place, false);
//                if (Objects.equals(seat.getRow(), vipRow) && place < maxVipPlace  && place > minVipPlace){
//                    seat.setVip(true);
//                }
//                seats.add(seat);
            }
        }
        auditorium.setSeats(seats);
        return auditorium;
    }


}
