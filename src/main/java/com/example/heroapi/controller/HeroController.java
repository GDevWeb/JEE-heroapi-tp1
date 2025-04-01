package com.example.heroapi.controller;

import com.example.heroapi.model.Hero;
import com.example.heroapi.service.HeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    // GET /api/heroes
    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    // GET /api/heroes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHeroById(@PathVariable Long id) {
        return heroService.getHeroById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/heroes/search?name=bat
    @GetMapping("/search")
    public List<Hero> searchHeroes(@RequestParam String name) {
        return heroService.searchHeroesByName(name);
    }

    // GET /api/heroes/random
    @GetMapping("/random")
    public ResponseEntity<Hero> getRandomHero() {
        Hero random = heroService.getRandomHero();
        if (random == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(random);
    }

    // POST /api/heroes
    @PostMapping
    public Hero createHero(@RequestBody Hero hero) {
        return heroService.createHero(hero);
    }
}

