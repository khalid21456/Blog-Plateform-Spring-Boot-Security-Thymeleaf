package com.Ensam.blogg.controllers;



import com.Ensam.blogg.PostDTO;
import com.Ensam.blogg.entities.Category;
import com.Ensam.blogg.entities.Post;
import com.Ensam.blogg.entities.Tag;
import com.Ensam.blogg.entities.User;
import com.Ensam.blogg.repositories.CategoryRepository;
import com.Ensam.blogg.repositories.PostRepository;
import com.Ensam.blogg.repositories.TagRepository;
import com.Ensam.blogg.repositories.UserRepository;
import com.Ensam.blogg.services.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("unused")

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/addPost")
    private String addPost(Model model) {
        model.addAttribute("postDTO",new PostDTO());
        return "pos";
    }

    @PostMapping("/addPostForm")
    private String addPostForm(@ModelAttribute PostDTO postDTO, Model model, HttpSession session) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setExtrait(postDTO.getExtrait());
        post.setImage("/images/PostImage.jpg");
        Long id = Optional.ofNullable(session.getAttribute("id"))
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
        System.out.println("Id de l'utilisateur : "+id);
        User user = userRepository.findById(id).get();
        post.setUser(user);
        Category category = categoryRepository.findByName(postDTO.getCategory());
        post.setCategory(category);
        String[] tags = postDTO.getTags().split(",");
        Set<Tag> Settags = new HashSet<>();

        for(String tagIter:tags) {
            Tag tag = Optional.ofNullable(tagRepository.findByTagName(tagIter))
                    .orElseGet(() -> {
                        Tag newTag = new Tag(tagIter);
                        return tagRepository.save(newTag);
                    });
            Settags.add(tag);
        }
        post.setTags(Settags);
        postRepository.save(post);

        return addPost(model);
    }

}
