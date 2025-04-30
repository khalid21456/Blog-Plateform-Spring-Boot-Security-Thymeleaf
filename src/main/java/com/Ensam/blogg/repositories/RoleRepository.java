package com.Ensam.blogg.repositories;

import com.Ensam.blogg.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
