package com.example.web.controller.dto.mapper;

import com.example.web.controller.dto.DisciplineDto;
import com.example.web.model.Discipline;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DisciplineDtoMapper {

  public DisciplineDto toDto(Discipline entity){
    if (entity== null) return null;
    return DisciplineDto.builder()
        .id(entity.getId())
        .name(entity.getName())
        .build();
  }

  public List<DisciplineDto> toDtoList(List<Discipline> entities){
    return entities.stream()
        .map(this::toDto)
        .toList();
  }

  public Discipline toEntity(DisciplineDto dto){
    return Discipline.builder()
        .id(dto.getId())
        .name(dto.getName())
        .build();
  }
}
