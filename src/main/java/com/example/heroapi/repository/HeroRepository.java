package com.example.heroapi.repository;

import com.example.heroapi.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Long> {

    // Recherche partielle par nom (insensible à la casse)
    List<Hero> findByNameContainingIgnoreCase(String name);
}
