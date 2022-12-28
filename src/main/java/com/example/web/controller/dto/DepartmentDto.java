package com.example.web.controller.dto;

import com.example.web.model.Faculty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDto {

  Integer id;

  FacultyDto faculty;

  String name;

  String shortName;

}
