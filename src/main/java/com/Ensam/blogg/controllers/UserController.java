package com.Ensam.blogg.controllers;

import com.Ensam.blogg.DTO.LoginDTO;
import com.Ensam.blogg.entities.Post;
import com.Ensam.blogg.entities.User;
import com.Ensam.blogg.repositories.PostRepository;
import com.Ensam.blogg.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")

@Controller
public class UserController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccueilController accueilController;

    @GetMapping("/admin")
    public String adminForm(Model model) {
        List<User> users = userRepository.findAll();
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        model.addAttribute("users",users);
        model.addAttribute("userr",new User());
        return "admin2";
    }

    @PostMapping("/admin/add")
    public String addUser(@ModelAttribute User userr, Model model) {

        userRepository.save(userr);
        return adminForm(model);
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        LoginDTO loginDTO = new LoginDTO();
        model.addAttribute("loginInfo",loginDTO);
        return "login";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("user",new User());
        return "profile";
    }

    @GetMapping("/admin/deleteUser/{idUser}")
    public String deleteUser(@PathVariable Long idUser, Model model) {
        userRepository.deleteById(idUser);
        return adminForm(model);
    }

    @PostMapping("/Sign")
    public String SignIn(@ModelAttribute LoginDTO loginDTO, Model model, HttpSession session) {
        User user = userRepository.findUserByEmailAndPassword(loginDTO.getUsername(),loginDTO.getPassword());
        if(user != null && user.getRole().equals("User")) {
            session.setAttribute("id",user.getId());
            session.setAttribute("prenom",user.getName());
            session.setAttribute("nom",user.getLname());
            session.setAttribute("email",user.getEmail());
            session.setAttribute("adress",user.getAdress());
            session.setAttribute("password",user.getPassword());
            return accueilController.getAccueil(model);
        }
        if(user != null && user.getRole().equals("Admin")) {
            return adminForm(model);
        }
        return "";
    }

    @GetMapping("/SignOut")
    public String SignOut(HttpSession session,Model model) {
        session.invalidate();
        return getLogin(model);
    }

}
