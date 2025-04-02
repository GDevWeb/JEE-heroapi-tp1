package com.example.heroapi.service;

import com.example.heroapi.model.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BattleServiceImpl implements BattleService {

    @Override
    public Hero battle(Hero hero1, Hero hero2) {
        int score1 = calculateTotalStats(hero1);
        int score2 = calculateTotalStats(hero2);

        if (score1 > score2) return hero1;
        else if (score2 > score1) return hero2;
        else return null; // Match nul
    }

    @Override
    public int calculateTotalStats(Hero hero) {
        return hero.getStrength() + hero.getDefense() + hero.getSpeed()
                + hero.getAccuracy() + hero.getIntelligence() + hero.getLuck();
    }
}
