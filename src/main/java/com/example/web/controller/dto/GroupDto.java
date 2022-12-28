package com.example.web.controller.dto;

import com.example.web.model.Department;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDto {
  Integer id;

  DepartmentDto department;

  String name;

  Integer course;
}
