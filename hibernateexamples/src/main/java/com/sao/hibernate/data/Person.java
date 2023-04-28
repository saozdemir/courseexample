package com.sao.hibernate.data;

import javax.persistence.*;

/**
 * @author saozd
 * @project com.sao.hibernate.data courseexample
 * 21.04.2023 Nis 2023
 */
@Entity
@Table(name = "person")
public class Person {
    @SequenceGenerator(name = "person", sequenceName = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 60)
    private String name;
    @Column(name = "SURNAME", length = 60)
    private String surname;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            optional = false,
            mappedBy = "person" //User altında tanımlanan attribute (private Person person;)
    )
    private User user;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
