package com.Ensam.blogg.repositories;

import com.Ensam.blogg.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findUserByEmailAndPassword(String email, String password);
    User findByName(String name);
}
