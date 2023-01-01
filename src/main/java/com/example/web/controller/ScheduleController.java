package com.example.web.controller;

import com.example.web.controller.dto.ScheduleDto;
import com.example.web.controller.dto.mapper.ScheduleDtoMapper;
import com.example.web.model.Department;
import com.example.web.model.Discipline;
import com.example.web.model.Group;
import com.example.web.model.Teacher;
import com.example.web.service.DisciplineService;
import com.example.web.service.GroupService;
import com.example.web.service.ScheduleService;
import java.util.List;

import com.example.web.service.TeacherService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ScheduleController {

  ScheduleService service;
  TeacherService teacherService;
  DisciplineService disciplineService;
  GroupService groupService;

  ScheduleDtoMapper dtoMapper;

  @GetMapping
  public List<ScheduleDto> getAll(){
    return dtoMapper.toDtoList(service.getAll());
  }

  @GetMapping("/{scheduleId}")
  public ScheduleDto getOne(@PathVariable Integer scheduleId){
    return dtoMapper.toDto(service.getByIdOrThrowException(scheduleId));
  }

  @PostMapping
  public ScheduleDto create(@RequestBody ScheduleDto scheduleDto){

    return dtoMapper.toDto(service.create(dtoMapper.toEntity(scheduleDto), scheduleDto.getTeacherId(),
            scheduleDto.getDisciplineId(), scheduleDto.getGroupId()));
  }

  @PutMapping("/{scheduleId}")
  public ScheduleDto edit(@PathVariable Integer scheduleId, @RequestBody ScheduleDto scheduleDto){
    return dtoMapper.toDto(service.edit(dtoMapper.toEntity(scheduleDto), scheduleId, scheduleDto.getTeacherId(),
            scheduleDto.getDisciplineId(), scheduleDto.getGroupId()));
  }

  @DeleteMapping("/{scheduleId}")
  public void delete(@PathVariable Integer scheduleId){
    service.delete(scheduleId);
  }
}
