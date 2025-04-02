package com.example.heroapi.controller;

import com.example.heroapi.dto.BattleRequest;
import com.example.heroapi.dto.BattleResultDTO;
import com.example.heroapi.dto.HeroDTO;
import com.example.heroapi.mapper.HeroMapper;
import com.example.heroapi.model.Hero;
import com.example.heroapi.service.BattleService;
import com.example.heroapi.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;
    private final HeroMapper heroMapper;
    private final BattleService battleService;

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

    @PostMapping("/battle")
    public ResponseEntity<BattleResultDTO> battle(@RequestBody BattleRequest request) {
        Hero hero1 = heroService.getHeroById(request.getHero1Id())
                .orElseThrow(() -> new RuntimeException("Hero 1 not found"));
        Hero hero2 = heroService.getHeroById(request.getHero2Id())
                .orElseThrow(() -> new RuntimeException("Hero 2 not found"));

        int total1 = battleService.calculateTotalStats(hero1);
        int total2 = battleService.calculateTotalStats(hero2);

        if (total1 == total2) {
            return ResponseEntity.ok(new BattleResultDTO(
                    null,
                    null,
                    "Match nul ! Les deux héros ont les mêmes statistiques."
            ));
        }

        Hero winner = (total1 > total2) ? hero1 : hero2;
        Hero loser = (winner.equals(hero1)) ? hero2 : hero1;

        return ResponseEntity.ok(new BattleResultDTO(
                heroMapper.toDto(winner),
                heroMapper.toDto(loser),
                winner.getName() + " remporte le combat !"
        ));
    }
}
