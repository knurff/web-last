package com.example.web.controller;

import com.example.web.controller.dto.TeacherDto;
import com.example.web.controller.dto.mapper.TeacherDtoMapper;
import com.example.web.service.TeacherService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "*")
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
