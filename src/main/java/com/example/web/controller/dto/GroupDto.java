package com.example.web.controller.dto;

import com.example.web.model.Department;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDto {
  Integer id;

  DepartmentDto department;

  @JsonProperty(access = Access.WRITE_ONLY)
  Integer departmentId;

  String name;

  Integer course;
}
