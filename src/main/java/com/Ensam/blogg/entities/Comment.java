package com.Ensam.blogg.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,  columnDefinition = "TEXT")
    private String content;

    public Comment() {}

    @OneToOne
    @JoinColumn(name = "post_id",unique = false)
    private Post post;

    @OneToOne
    @JoinColumn(name = "user_id",unique = false)
    private User user_comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String comment) {
        this.content = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(User user_comment) {
        this.user_comment = user_comment;
    }
}
