package com.epam.cinema.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "EVENTS")
@Access(AccessType.FIELD)
@SequenceGenerator(name = "event_sequence", initialValue = 100, allocationSize = 100)
@NamedQueries({
        @NamedQuery(name = "findAllEvents", query = "select e from Event e where e.deletedDate = null"),
        @NamedQuery(name = "findEventWithId", query = "select e from Event e where e.id = :id and e.deletedDate = null"),
        @NamedQuery(name = "findAllEventWithName", query = "select e from Event e where e.name = :name and e.deletedDate = null")
})
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_sequence")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "base_price")
    private BigDecimal basePrice;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rating_id")
    private Rating rating;
    @Column(name = "description")
    private String description;
    @Column(name = "picture_link")
    private String pictureLink;
    @Column(name = "deleted_date")
    private Timestamp deletedDate;

    public Event() {
    }

    public Event(Long id, String name, BigDecimal basePrice, Rating rating, String description, String pictureLink, Timestamp deletedDate) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.rating = rating;
        this.description = description;
        this.pictureLink = pictureLink;
        this.deletedDate = deletedDate;
    }

    public Timestamp getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Timestamp deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (basePrice != null ? !basePrice.equals(event.basePrice) : event.basePrice != null) return false;
        if (rating != event.rating) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        return pictureLink != null ? pictureLink.equals(event.pictureLink) : event.pictureLink == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (basePrice != null ? basePrice.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pictureLink != null ? pictureLink.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", pictureLink='" + pictureLink + '\'' +
                '}';
    }
}
