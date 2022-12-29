package com.example.web.controller.dto;

import com.example.web.model.Faculty;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDto {

  Integer id;

  //  @JsonProperty(access = Access.READ_ONLY)
  FacultyDto faculty;

  @JsonProperty(access = Access.WRITE_ONLY)
  Integer facultyId;

  String name;

  String shortName;

}
