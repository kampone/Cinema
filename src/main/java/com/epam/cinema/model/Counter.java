package com.epam.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "DISCOUNT_COUNTERS")
@Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "findCounterByEventName", query = "select c from Counter c where c.eventName = :eventName")
})
public class Counter {
    @Id
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "name_invocation_count")
    private Long nameInvocationCount;
    @Column(name = "book_ticket_count")
    private Long bookTicketCount;

    public Counter() {
    }

    public Counter(String eventName, Long getNameCount, Long bookTicketCount) {
        this.eventName = eventName;
        this.nameInvocationCount = getNameCount;
        this.bookTicketCount = bookTicketCount;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getNameInvocationCount() {
        return nameInvocationCount;
    }

    public void setNameInvocationCount(Long nameInvocationCount) {
        this.nameInvocationCount = nameInvocationCount;
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
        if (nameInvocationCount != null ? !nameInvocationCount.equals(counter.nameInvocationCount) : counter.nameInvocationCount != null)
            return false;
        return bookTicketCount != null ? bookTicketCount.equals(counter.bookTicketCount) : counter.bookTicketCount == null;
    }

    @Override
    public int hashCode() {
        int result = eventName != null ? eventName.hashCode() : 0;
        result = 31 * result + (nameInvocationCount != null ? nameInvocationCount.hashCode() : 0);
        result = 31 * result + (bookTicketCount != null ? bookTicketCount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "eventName='" + eventName + '\'' +
                ", nameInvocationCount=" + nameInvocationCount +
                ", bookTicketCount=" + bookTicketCount +
                '}';
    }
}
