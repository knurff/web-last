package com.example.web.controller.dto.mapper;

import com.example.web.controller.dto.ScheduleDto;
import com.example.web.model.Schedule;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ScheduleDtoMapper {

  TeacherDtoMapper teacherDtoMapper;

  DisciplineDtoMapper disciplineDtoMapper;

  GroupDtoMapper groupDtoMapper;

  public ScheduleDto toDto(Schedule entity){
    return ScheduleDto.builder()
        .id(entity.getId())
        .name(entity.getName())
        .teacher(teacherDtoMapper.toDto(entity.getTeacher()))
        .discipline(disciplineDtoMapper.toDto(entity.getDiscipline()))
        .group(groupDtoMapper.toDto(entity.getGroup()))
        .classroom(entity.getClassroom())
        .build();
  }

  public List<ScheduleDto> toDtoList(List<Schedule> entities){
    return entities.stream()
        .map(this::toDto)
        .toList();
  }

  public Schedule toEntity(ScheduleDto dto){
    return Schedule.builder()
        .id(dto.getId())
        .name(dto.getName())
//        .teacher(teacherDtoMapper.toEntity(dto.getTeacher()))
//        .discipline(disciplineDtoMapper.toEntity(dto.getDiscipline()))
//        .group(groupDtoMapper.toEntity(dto.getGroup()))
        .classroom(dto.getClassroom())
        .build();
  }
}
