package com.example.web.controller;

import com.example.web.controller.dto.DepartmentDto;
import com.example.web.controller.dto.FacultyDto;
import com.example.web.controller.dto.mapper.DepartmentDtoMapper;
import com.example.web.model.Department;
import com.example.web.model.Faculty;
import com.example.web.service.DepartmentService;
import com.example.web.service.FacultyService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/department")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DepartmentController {

  DepartmentService service;
  FacultyService facultyService;

  DepartmentDtoMapper dtoMapper;

  @GetMapping
  public List<DepartmentDto> getAll(){

    return dtoMapper.toDtoList(service.getAll());
  }

  @GetMapping("/{departmentId}")
  public DepartmentDto getOne(@PathVariable Integer departmentId){
    return dtoMapper.toDto(service.getByIdOrThrowException(departmentId));
  }

  @PostMapping
  public DepartmentDto create(@RequestBody DepartmentDto departmentDto){

    Faculty faculty = facultyService.getByIdOrThrowException(departmentDto.getFacultyId());
    Department department = service.create(dtoMapper.toEntity(departmentDto), faculty.getId());
    return dtoMapper.toDto
        (department
//            service.create(
//        dtoMapper.toEntity(
//        departmentDto)
//        )
    );
  }

  @PutMapping("/{departmentId}")
  public DepartmentDto edit(@PathVariable Integer departmentId, @RequestBody DepartmentDto departmentDto){
    return dtoMapper.toDto(service.edit(dtoMapper.toEntity(departmentDto), departmentId, departmentDto.getFacultyId()));
  }

  @DeleteMapping("/{departmentId}")
  public void delete(@PathVariable Integer departmentId){
    service.delete(departmentId);
  }
}
