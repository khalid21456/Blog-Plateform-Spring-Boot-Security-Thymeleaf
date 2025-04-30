package com.Ensam.blogg.repositories;

import com.Ensam.blogg.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    public Tag findByTagName(String tagName);
}
