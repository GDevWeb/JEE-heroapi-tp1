package com.example.heroapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BattleResultDTO {
    private HeroDTO winner;
    private HeroDTO loser;
    private String message;
}
