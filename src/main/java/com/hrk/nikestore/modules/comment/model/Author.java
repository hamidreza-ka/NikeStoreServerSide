package com.hrk.nikestore.modules.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {

    @Id
    @JsonIgnore
    private Long id;

    private String email;
    private String Name;


    public Author() {
    }

    public Author(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
