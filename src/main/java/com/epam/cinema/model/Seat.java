package com.epam.cinema.model;

public class Seat {
    private Integer row;
    private Integer place;
    private boolean isVip;

    public Seat(Integer row, Integer place, boolean isVip) {
        this.row = row;
        this.place = place;
        this.isVip = isVip;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public Integer getRow() {
        return row;
    }


    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (isVip != seat.isVip) return false;
        if (row != null ? !row.equals(seat.row) : seat.row != null) return false;
        return place != null ? place.equals(seat.place) : seat.place == null;
    }

    @Override
    public int hashCode() {
        int result = row != null ? row.hashCode() : 0;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (isVip ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", place=" + place +
                ", isVip=" + isVip +
                '}';
    }
}
