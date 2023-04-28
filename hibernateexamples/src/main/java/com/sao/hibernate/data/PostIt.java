package com.sao.hibernate.data;

import javax.persistence.*;

/**
 * @author saozd
 * @project com.sao.hibernate.data courseexample
 * 21.04.2023 Nis 2023
 */
@Entity
@Table(name="postit")
public class PostIt {
    @SequenceGenerator(name="postit", sequenceName = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "POST")
    private String post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
