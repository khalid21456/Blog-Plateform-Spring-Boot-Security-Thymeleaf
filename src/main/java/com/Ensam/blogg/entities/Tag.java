package com.Ensam.blogg.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")

@Entity

public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Tag() {}

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();

}
