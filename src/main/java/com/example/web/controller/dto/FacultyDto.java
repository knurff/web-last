package com.example.web.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacultyDto {

  Integer id;

  String name;

  String shortName;

}
