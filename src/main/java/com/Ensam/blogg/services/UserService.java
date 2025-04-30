package com.Ensam.blogg.services;

import com.Ensam.blogg.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unused")

public class UserService {


    @Autowired
    public UserRepository userRepository;
}
