package com.example.heroapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroDTO {
    private Long id;
    private String name;
    private String universe;
    private int strength;
    private int defense;
    private int speed;
    private int accuracy;
    private int intelligence;
    private int luck;
    private int powerLevel; // Champ calculé

    public HeroDTO() {}

    public HeroDTO(Long id, String name, String universe, int strength, int defense, int speed,
                   int accuracy, int intelligence, int luck) {
        this.id = id;
        this.name = name;
        this.universe = universe;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.accuracy = accuracy;
        this.intelligence = intelligence;
        this.luck = luck;
        calculatePowerLevel();
    }

    // Méthode pour calculer le powerLevel à partir des autres statistiques
    public void calculatePowerLevel() {
        this.powerLevel = strength + defense + speed + accuracy + intelligence + luck;
    }
}
