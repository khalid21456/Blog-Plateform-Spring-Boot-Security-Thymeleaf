package com.Ensam.blogg.services;


import com.Ensam.blogg.PostDTO;
import com.Ensam.blogg.entities.Category;
import com.Ensam.blogg.entities.Post;
import com.Ensam.blogg.entities.User;
import com.Ensam.blogg.repositories.CategoryRepository;
import com.Ensam.blogg.repositories.PostRepository;
import com.Ensam.blogg.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Optional;

@SuppressWarnings("unused")

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    public String ajouterPost(Model model, @ModelAttribute PostDTO newpost) {
        /*
        Category category = Optional.ofNullable(categoryRepository.findByName(product.getCategory().getName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(product.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        */
        Category category = categoryRepository.findByName(newpost.getCategory());

        return "";
    }



}
