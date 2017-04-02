package com.epam.cinema.model;


public class Counter {
    private String eventName;
    private Long getNameCount;
    private Long bookTicketCount;

    public Counter() {
    }

    public Counter(String eventName, Long getNameCount, Long bookTicketCount) {
        this.eventName = eventName;
        this.getNameCount = getNameCount;
        this.bookTicketCount = bookTicketCount;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getGetNameCount() {
        return getNameCount;
    }

    public void setGetNameCount(Long getNameCount) {
        this.getNameCount = getNameCount;
    }

    public Long getBookTicketCount() {
        return bookTicketCount;
    }

    public void setBookTicketCount(Long bookTicketCount) {
        this.bookTicketCount = bookTicketCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Counter counter = (Counter) o;

        if (eventName != null ? !eventName.equals(counter.eventName) : counter.eventName != null) return false;
        if (getNameCount != null ? !getNameCount.equals(counter.getNameCount) : counter.getNameCount != null)
            return false;
        return bookTicketCount != null ? bookTicketCount.equals(counter.bookTicketCount) : counter.bookTicketCount == null;
    }

    @Override
    public int hashCode() {
        int result = eventName != null ? eventName.hashCode() : 0;
        result = 31 * result + (getNameCount != null ? getNameCount.hashCode() : 0);
        result = 31 * result + (bookTicketCount != null ? bookTicketCount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "eventName='" + eventName + '\'' +
                ", getNameCount=" + getNameCount +
                ", bookTicketCount=" + bookTicketCount +
                '}';
    }
}
