package com.example.web.controller;

import com.example.web.controller.dto.ScheduleDto;
import com.example.web.controller.dto.mapper.ScheduleDtoMapper;
import com.example.web.service.ScheduleService;
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
@RequestMapping("/schedules")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ScheduleController {

  ScheduleService service;

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
    return dtoMapper.toDto(service.create(dtoMapper.toEntity(scheduleDto)));
  }

  @PutMapping("/{scheduleId}")
  public ScheduleDto edit(@PathVariable Integer scheduleId, @RequestBody ScheduleDto scheduleDto){
    return dtoMapper.toDto(service.edit(dtoMapper.toEntity(scheduleDto), scheduleId));
  }

  @DeleteMapping("/{scheduleId}")
  public void delete(@PathVariable Integer scheduleId){
    service.delete(scheduleId);
  }
}
