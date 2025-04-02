package com.example.heroapi.service;

import com.example.heroapi.model.Hero;

public interface BattleService {
    Hero battle(Hero hero1, Hero hero2);
    int calculateTotalStats(Hero hero);
}
