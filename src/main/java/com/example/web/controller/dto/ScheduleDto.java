package com.example.web.controller.dto;

import com.example.web.model.Discipline;
import com.example.web.model.Group;
import com.example.web.model.Teacher;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleDto {

  Integer id;

  String name;

  TeacherDto teacher;

  DisciplineDto discipline;

  GroupDto group;

  LocalDateTime time;

  String classroom;
}
