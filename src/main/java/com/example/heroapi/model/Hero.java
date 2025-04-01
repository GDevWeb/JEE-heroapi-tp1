package com.example.heroapi.model;

import jakarta.persistence.*;

@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String universe;
    private int powerLevel;

    public void setName(String name) {
        this.name = name;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

}
