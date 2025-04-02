package com.example.heroapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeroDTO {
    private String name;
    private int powerLevel;
    private String universe;
}
