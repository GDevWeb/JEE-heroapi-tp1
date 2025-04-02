package com.example.heroapi.controller;

import com.example.heroapi.model.Hero;
import com.example.heroapi.service.HeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.heroapi.dto.HeroDTO;
import com.example.heroapi.mapper.HeroMapper;


import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;
    private final HeroMapper heroMapper;

    public HeroController(HeroService heroService, HeroMapper heroMapper) {
        this.heroService = heroService;
        this.heroMapper = heroMapper;
    }

    @GetMapping
    public List<HeroDTO> getAllHeroes() {
        return heroMapper.toDtoList(heroService.getAllHeroes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> getHeroById(@PathVariable Long id) {
        return heroService.getHeroById(id)
                .map(heroMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<HeroDTO> searchHeroes(@RequestParam String name) {
        return heroMapper.toDtoList(heroService.searchHeroesByName(name));
    }

    @GetMapping("/random")
    public ResponseEntity<HeroDTO> getRandomHero() {
        Hero random = heroService.getRandomHero();
        if (random == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(heroMapper.toDto(random));
    }

    @PostMapping
    public ResponseEntity<HeroDTO> createHero(@RequestBody HeroDTO heroDTO) {
        Hero heroToSave = heroMapper.toEntity(heroDTO);
        Hero saved = heroService.createHero(heroToSave);
        return ResponseEntity.ok(heroMapper.toDto(saved));
    }
}
