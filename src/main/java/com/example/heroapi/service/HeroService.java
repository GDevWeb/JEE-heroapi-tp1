package com.example.heroapi.service;

import com.example.heroapi.model.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroService {
    List<Hero> getAllHeroes();
    Optional<Hero> getHeroById(Long id);
    List<Hero> searchHeroesByName(String name);
    Hero getRandomHero();
    Hero createHero(Hero hero);
}
