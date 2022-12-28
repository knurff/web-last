package com.example.web.controller;

import com.example.web.controller.dto.TeacherDto;
import com.example.web.controller.dto.mapper.TeacherDtoMapper;
import com.example.web.service.TeacherService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TeacherController {

  TeacherService service;

  TeacherDtoMapper dtoMapper;

  @GetMapping
  public List<TeacherDto> getAll(){
    return dtoMapper.toDtoList(service.getAll());
  }

  @GetMapping("/{teacherId}")
  public TeacherDto getOne(@PathVariable Integer teacherId){
    return dtoMapper.toDto(service.getByIdOrThrowException(teacherId));
  }

  @PostMapping
  public TeacherDto create(@RequestBody TeacherDto teacherDto){
    return dtoMapper.toDto(service.create(dtoMapper.toEntity(teacherDto)));
  }

  @PutMapping("/{teacherId}")
  public TeacherDto edit(@PathVariable Integer teacherId, @RequestBody TeacherDto teacherDto){
    return dtoMapper.toDto(service.edit(dtoMapper.toEntity(teacherDto), teacherId));
  }

  @DeleteMapping("/{teacherId}")
  public void delete(@PathVariable Integer teacherId){
    service.delete(teacherId);
  }
}
