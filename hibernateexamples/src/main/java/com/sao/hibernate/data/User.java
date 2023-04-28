package com.sao.hibernate.data;

import javax.persistence.*;

/**
 * @author saozd
 * @project com.sao.hibernate.data courseexample
 * 21.04.2023 Nis 2023
 */
@Entity
@Table(name = "user")
public class User {
    @SequenceGenerator(name = "user", sequenceName = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_NAME", length = 10)
    private String userName;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            optional = false
    )
    private Person person;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
