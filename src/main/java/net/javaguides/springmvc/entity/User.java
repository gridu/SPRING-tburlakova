package net.javaguides.springmvc.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="User")
@Table(name="USERS")
public class User {

    public User() {}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(
            mappedBy="user",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Phone> phones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", phones=" + phones + "]";
    }
}
