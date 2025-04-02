package com.example.heroapi.mapper;

import com.example.heroapi.dto.HeroDTO;
import com.example.heroapi.model.Hero;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring") // nécessaire pour l'injection
public interface HeroMapper {

    HeroMapper INSTANCE = Mappers.getMapper(HeroMapper.class);

    HeroDTO toDto(Hero hero);
    Hero toEntity(HeroDTO dto);

    List<HeroDTO> toDtoList(List<Hero> heroes);
}
