package com.example.web.controller;

import com.example.web.controller.dto.GroupDto;
import com.example.web.controller.dto.mapper.GroupDtoMapper;
import com.example.web.model.Department;
import com.example.web.model.Faculty;
import com.example.web.model.Group;
import com.example.web.service.DepartmentService;
import com.example.web.service.FacultyService;
import com.example.web.service.GroupService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
@CrossOrigin(origins = "http://localhost:8080")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroupController {

  GroupService service;
  DepartmentService departmentService;

  GroupDtoMapper dtoMapper;

  FacultyService facultyService;


  @GetMapping
  public List<GroupDto> getAll(){
    return dtoMapper.toDtoList(service.getAll());
  }

  @GetMapping("/{groupId}")
  public GroupDto getOne(@PathVariable Integer groupId){
    return dtoMapper.toDto(service.getByIdOrThrowException(groupId));
  }

  @PostMapping
  public GroupDto create(@RequestBody GroupDto groupDto){
//    Department department = departmentService.getByIdOrThrowException(groupDto.getDepartmentId());
    Group group = service.create(dtoMapper.toEntity(groupDto), groupDto.getDepartmentId());
    return dtoMapper.toDto(group);
  }

  @PutMapping("/{groupId}")
  public GroupDto edit(@PathVariable Integer groupId, @RequestBody GroupDto groupDto){
    return dtoMapper.toDto(service.edit(dtoMapper.toEntity(groupDto), groupId, groupDto.getDepartmentId()));
  }

  @DeleteMapping("/{groupId}")
  public void delete(@PathVariable Integer groupId){
    service.delete(groupId);
  }
}
