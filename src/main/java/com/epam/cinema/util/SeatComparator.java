package com.epam.cinema.util;

import com.epam.cinema.model.Seat;

import java.util.Comparator;

public class SeatComparator implements Comparator<Seat>
{
    @Override
    public int compare(Seat o1, Seat o2) {
        int res = Integer.compare(o1.getRow(), o2.getRow());
        if (res == 0) {
            return Integer.compare(o1.getPlace(), o2.getPlace());
        }
        return res;
    }
}
