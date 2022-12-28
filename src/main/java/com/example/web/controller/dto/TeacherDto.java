package com.example.web.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDto {

  Integer id;

  String name;

  String surname;

  String email;

  String phone;

}
