package com.Ensam.blogg.repositories;


import com.Ensam.blogg.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByName(String name);
}
