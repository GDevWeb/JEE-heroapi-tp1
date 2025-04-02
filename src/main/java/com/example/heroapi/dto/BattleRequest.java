package com.example.heroapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BattleRequest {
    private Long hero1Id;
    private Long hero2Id;
}
