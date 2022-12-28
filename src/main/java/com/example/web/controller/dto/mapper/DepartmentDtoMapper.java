package com.example.web.controller.dto.mapper;

import com.example.web.controller.dto.DepartmentDto;
import com.example.web.model.Department;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DepartmentDtoMapper {

  FacultyDtoMapper facultyDtoMapper;

  public DepartmentDto toDto(Department entity){
    return DepartmentDto.builder()
        .id(entity.getId())
        .faculty(facultyDtoMapper.toDto(entity.getFaculty()))
        .name(entity.getName())
        .shortName(entity.getShortName())
        .build();
  }

  public List<DepartmentDto> toDtoList(List<Department> entities){
    return entities.stream()
        .map(this::toDto)
        .toList();
  }

  public Department toEntity(DepartmentDto dto){
    return Department.builder()
        .id(dto.getId())
        .faculty(facultyDtoMapper.toEntity(dto.getFaculty()))
        .name(dto.getName())
        .shortName(dto.getShortName())
        .build();
  }

}
