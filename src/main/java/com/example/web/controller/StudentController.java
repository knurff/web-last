package com.example.web.controller;

import com.example.web.controller.dto.StudentDto;
import com.example.web.controller.dto.mapper.StudentDtoMapper;
import com.example.web.model.Student;
import com.example.web.service.StudentService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:8080")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentController {

  StudentService service;

  StudentDtoMapper dtoMapper;

  @GetMapping
  public List<StudentDto> getAll(){
    return dtoMapper.toDtoList(service.getAll());
  }

  @GetMapping("/{studentId}")
  public StudentDto getOne(@PathVariable Integer studentId){
    return dtoMapper.toDto(service.getByIdOrThrowException(studentId));
  }

  @PostMapping
  public StudentDto create(@RequestBody StudentDto studentDto){
    Student student = service.create(dtoMapper.toEntity(studentDto), studentDto.getGroupId());
    return dtoMapper.toDto(student);
  }

  @PutMapping("/{studentId}")
  public StudentDto edit(@PathVariable Integer studentId, @RequestBody StudentDto studentDto){
    return dtoMapper.toDto(service.edit(dtoMapper.toEntity(studentDto), studentId, studentDto.getGroupId()));
  }

  @DeleteMapping("/{studentId}")
  public void delete(@PathVariable Integer studentId){
    service.delete(studentId);
  }
}
