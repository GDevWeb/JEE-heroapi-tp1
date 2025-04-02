package com.example.heroapi.mapper;

import com.example.heroapi.dto.HeroDTO;
import com.example.heroapi.model.Hero;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HeroMapper {

    HeroDTO toDto(Hero hero);

    Hero toEntity(HeroDTO dto);

    List<HeroDTO> toDtoList(List<Hero> heroes);

    @AfterMapping
    default void calculatePowerLevel(@MappingTarget HeroDTO dto) {
        dto.calculatePowerLevel();
    }
}
