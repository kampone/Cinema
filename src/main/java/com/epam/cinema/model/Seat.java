package com.epam.cinema.model;

public class Seat {
    private Long id;
    private Integer row;
    private Integer place;
    private boolean isVip;

    public Seat() {
    }

    public Seat(Long id, Integer row, Integer place, boolean isVip) {
        this.id = id;
        this.row = row;
        this.place = place;
        this.isVip = isVip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (isVip != seat.isVip) return false;
        if (id != null ? !id.equals(seat.id) : seat.id != null) return false;
        if (row != null ? !row.equals(seat.row) : seat.row != null) return false;
        return place != null ? place.equals(seat.place) : seat.place == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (row != null ? row.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (isVip ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", row=" + row +
                ", place=" + place +
                ", isVip=" + isVip +
                '}';
    }
}
