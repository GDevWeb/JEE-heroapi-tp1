package com.example.heroapi.service;

import com.example.heroapi.model.Hero;
import com.example.heroapi.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final Random random = new Random();

    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @Override
    public Optional<Hero> getHeroById(Long id) {
        return heroRepository.findById(id);
    }

    @Override
    public List<Hero> searchHeroesByName(String name) {
        return heroRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Hero getRandomHero() {
        List<Hero> all = heroRepository.findAll();
        if (all.isEmpty()) return null;
        return all.get(random.nextInt(all.size()));
    }

    @Override
    public Hero createHero(Hero hero) {
        return heroRepository.save(hero);
    }
}
