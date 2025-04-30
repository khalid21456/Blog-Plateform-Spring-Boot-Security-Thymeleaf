package com.Ensam.blogg.controllers;


import com.Ensam.blogg.entities.Comment;
import com.Ensam.blogg.entities.Post;
import com.Ensam.blogg.repositories.CommentRepository;
import com.Ensam.blogg.repositories.PostRepository;
import com.Ensam.blogg.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@SuppressWarnings("unused")

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleController articleController;

    @GetMapping("/commenter")
    public String addComment(Model model, @ModelAttribute Comment commentaire, HttpSession session) {

        Long idPost = Optional.ofNullable(session.getAttribute("idPost"))
                .map(attr -> {
                    if (attr instanceof Long) {
                        return (Long) attr;
                    } else if (attr instanceof Integer) {
                        return ((Integer) attr).longValue();
                    } else if (attr instanceof String)  {
                        try {
                            return Long.parseLong((String) attr);
                        } catch (NumberFormatException e) {
                            return null;
                        }
                    }
                    return null;
                })
                .orElse(null);

        Long idUser = Optional.ofNullable(session.getAttribute("id"))
                .map(attr -> {
                    if (attr instanceof Long) {
                        return (Long) attr;
                    } else if (attr instanceof Integer) {
                        return ((Integer) attr).longValue();
                    } else if (attr instanceof String) {
                        try {
                            return Long.parseLong((String) attr);
                        } catch (NumberFormatException e) {
                            return null;
                        }
                    }
                    return null;
                })
                .orElse(null);
        System.out.println("id user : "+idUser);
        System.out.println("id post : "+idPost);
        commentaire.setUser_comment(userRepository.findById(idUser).get());
        commentaire.setPost(postRepository.findById(idPost).get());
        commentRepository.save(commentaire);
        return articleController.getArticle(commentaire.getPost().getId(), model,session);
    }
}