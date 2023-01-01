package com.example.web.controller.dto;

import com.example.web.model.Discipline;
import com.example.web.model.Group;
import com.example.web.model.Teacher;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleDto {

  Integer id;

  String name;

  TeacherDto teacher;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

  Integer teacherId;

  DisciplineDto discipline;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

  Integer disciplineId;

  GroupDto group;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

  Integer groupId;

  LocalDateTime time;

  String classroom;
}
