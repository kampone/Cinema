package com.epam.cinema.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "POPCORN")
@Access(AccessType.FIELD)
@SequenceGenerator(name = "popcorn_sequence", initialValue = 100, allocationSize = 100)
public class Popcorn {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "popcorn_sequence")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "POPCORN_USER",
            inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "popcorn_id", referencedColumnName = "id")
    )
    private List<User> users;

    public Popcorn() {
    }

    public Popcorn(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Popcorn popcorn = (Popcorn) o;

        if (id != null ? !id.equals(popcorn.id) : popcorn.id != null) return false;
        return name != null ? name.equals(popcorn.name) : popcorn.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Popcorn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
