package com.sao.hibernate.data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author saozd
 * @project com.sao.hibernate.data courseexample
 * 10.05.2023 May 2023
 */
@Entity
@Table(name = "BOOK")
public class Book {

    @SequenceGenerator(name = "book", sequenceName = "BOOK_ID")
    @Id
    @GeneratedValue(generator = "book", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 100)
    private String name;
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = Author.class
    )
    private Set authors = new HashSet();

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

    public Set getAuthors() {
        return authors;
    }

    public void setAuthors(Set authors) {
        this.authors = authors;
    }
}
