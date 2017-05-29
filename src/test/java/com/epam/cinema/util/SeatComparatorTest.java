package com.epam.cinema.util;

import com.epam.cinema.model.Seat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class SeatComparatorTest {
    private SeatComparator seatComparator = new SeatComparator();

    @Test
    public void compare_FirstMoreThanSecond() throws Exception {
        Seat first = new Seat();
        Seat second = new Seat();

        first.setPlace(1);
        first.setRow(2);

        second.setPlace(2);
        second.setRow(3);

        assertEquals(Integer.valueOf(-1), Integer.valueOf(seatComparator.compare(first, second)));
    }

    @Test
    public void compare_SecondMoreThanFirst() throws Exception {
        Seat first = new Seat();
        Seat second = new Seat();

        first.setPlace(3);
        first.setRow(3);

        second.setPlace(2);
        second.setRow(2);

        assertEquals(Integer.valueOf(1), Integer.valueOf(seatComparator.compare(first, second)));
    }

    @Test
    public void compare_Equals() throws Exception {
        Seat first = new Seat();
        Seat second = new Seat();

        first.setPlace(3);
        first.setRow(3);

        second.setPlace(3);
        second.setRow(3);

        assertEquals(Integer.valueOf(0), Integer.valueOf(seatComparator.compare(first, second)));
    }
}