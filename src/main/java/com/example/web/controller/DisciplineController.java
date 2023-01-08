package com.example.web.controller;

import com.example.web.controller.dto.DisciplineDto;
import com.example.web.controller.dto.mapper.DisciplineDtoMapper;
import com.example.web.service.DisciplineService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/discipline")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DisciplineController {

  DisciplineService service;

  DisciplineDtoMapper dtoMapper;

  @GetMapping
  public List<DisciplineDto> getAll(){
    return dtoMapper.toDtoList(service.getAll());
  }

  @GetMapping("/{disciplineId}")
  public DisciplineDto getOne(@PathVariable Integer disciplineId){
    return dtoMapper.toDto(service.getByIdOrThrowException(disciplineId));
  }

  @PostMapping
  public DisciplineDto create(@RequestBody DisciplineDto disciplineDto){
    return dtoMapper.toDto(service.create(dtoMapper.toEntity(disciplineDto)));
  }

  @PutMapping("/{disciplineId}")
  public DisciplineDto edit(@PathVariable Integer disciplineId, @RequestBody DisciplineDto disciplineDto){
    return dtoMapper.toDto(service.edit(dtoMapper.toEntity(disciplineDto), disciplineId));
  }

  @DeleteMapping("/{disciplineId}")
  public void delete(@PathVariable Integer disciplineId){
    service.delete(disciplineId);
  }
}
