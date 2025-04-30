package com.Ensam.blogg.controllers;


import com.Ensam.blogg.entities.Comment;
import com.Ensam.blogg.entities.Post;
import com.Ensam.blogg.entities.Tag;
import com.Ensam.blogg.entities.User;
import com.Ensam.blogg.repositories.CommentRepository;
import com.Ensam.blogg.repositories.PostRepository;
import com.Ensam.blogg.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")

@Controller
public class ArticleController {

    @Autowired
    private UserController userController;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/article")
    public String getArticle(@RequestParam Long idPost, Model model, HttpSession session) {
        Post post = postRepository.findById(idPost).get();
        model.addAttribute("commentaire",new Comment());
        model.addAttribute("comments",post.getComments());
        model.addAttribute("article",post);
        session.setAttribute("idPost",idPost);
        return "article";
    }

    @GetMapping("/admin/deleteArticle/{idPost}")
    public String deletePost(@PathVariable Long idPost, Model model) {
        postRepository.deleteById(idPost);
        return userController.adminForm(model);
    }

}
