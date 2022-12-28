package com.example.web.controller.dto.mapper;

import com.example.web.controller.dto.TeacherDto;
import com.example.web.model.Teacher;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TeacherDtoMapper {

  public TeacherDto toDto(Teacher entity){
    return TeacherDto.builder()
        .id(entity.getId())
        .name(entity.getName())
        .surname(entity.getSurname())
        .email(entity.getEmail())
        .phone(entity.getPhone())
        .build();
  }

  public List<TeacherDto> toDtoList(List<Teacher> entities){
    return entities.stream()
        .map(this::toDto)
        .toList();
  }

  public Teacher toEntity(TeacherDto dto){
    return Teacher.builder()
        .id(dto.getId())
        .name(dto.getName())
        .surname(dto.getSurname())
        .email(dto.getEmail())
        .phone(dto.getPhone())
        .build();
  }
}
