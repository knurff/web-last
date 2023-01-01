package com.example.web.controller;

import com.example.web.controller.dto.FacultyDto;
import com.example.web.controller.dto.mapper.FacultyDtoMapper;
import com.example.web.service.FacultyService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/faculty")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FacultyController {

  FacultyService service;

  FacultyDtoMapper dtoMapper;

  @GetMapping
  public List<FacultyDto> getAll(){
    return dtoMapper.toDtoList(service.getAll());
  }

  @GetMapping("/{facultyId}")
  public FacultyDto getOne(@PathVariable Integer facultyId){
    return dtoMapper.toDto(service.getByIdOrThrowException(facultyId));
  }

  @PostMapping
  public FacultyDto create(@RequestBody FacultyDto facultyDto){
    return dtoMapper.toDto(service.create(dtoMapper.toEntity(facultyDto)));
  }

  @PutMapping("/{facultyId}")
  public FacultyDto edit( @PathVariable Integer facultyId, @RequestBody FacultyDto facultyDto){
    return dtoMapper.toDto(service.edit(dtoMapper.toEntity(facultyDto), facultyId));
  }

  @DeleteMapping("/{facultyId}")
  public void delete(@PathVariable Integer facultyId){
    service.delete(facultyId);
  }
}
