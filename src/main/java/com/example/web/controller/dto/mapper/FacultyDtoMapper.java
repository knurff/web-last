package com.example.web.controller.dto.mapper;

import com.example.web.controller.dto.FacultyDto;
import com.example.web.model.Faculty;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FacultyDtoMapper {

  public FacultyDto toDto(Faculty entity){
    return FacultyDto.builder()
        .id(entity.getId())
        .name(entity.getName())
        .shortName(entity.getShortName())
        .build();
  }

  public List<FacultyDto> toDtoList(List<Faculty> entities){
    return entities.stream()
        .map(this::toDto)
        .toList();
  }

  public Faculty toEntity(FacultyDto dto){
    return Faculty.builder()
        .id(dto.getId())
        .name(dto.getName())
        .shortName(dto.getShortName())
        .build();
  }
}
