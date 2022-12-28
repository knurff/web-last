package com.example.web.controller.dto.mapper;

import com.example.web.controller.dto.StudentDto;
import com.example.web.model.Student;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentDtoMapper {

  GroupDtoMapper groupDtoMapper;

  public StudentDto toDto(Student entity){
    return StudentDto.builder()
        .id(entity.getId())
        .group(groupDtoMapper.toDto(entity.getGroup()))
        .name(entity.getName())
        .email(entity.getEmail())
        .phone(entity.getPhone())
        .build();
  }

  public List<StudentDto> toDtoList(List<Student> entities){
    return entities.stream()
        .map(this::toDto)
        .toList();
  }

  public Student toEntity(StudentDto dto){
    return Student.builder()
        .id(dto.getId())
        .group(groupDtoMapper.toEntity(dto.getGroup()))
        .name(dto.getName())
        .email(dto.getEmail())
        .phone(dto.getPhone())
        .build();
  }
}
