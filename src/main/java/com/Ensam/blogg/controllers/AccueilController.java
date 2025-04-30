package com.Ensam.blogg.controllers;

import com.Ensam.blogg.PostDTO;
import com.Ensam.blogg.entities.Post;
import com.Ensam.blogg.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@SuppressWarnings("unused")

@Controller
public class AccueilController {

    @Autowired
    public PostRepository postRepository;

    @GetMapping("/")
    public String getAccueil(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        return "accueil2";
    }

    @GetMapping("/posting")
    public String getPostForm(Model model) {
        PostDTO postDTO = new PostDTO();
        model.addAttribute("postDTO",postDTO);
        return "pos";
    }
}
