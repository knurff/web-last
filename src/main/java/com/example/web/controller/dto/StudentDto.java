package com.example.web.controller.dto;

import com.example.web.model.Group;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

  Integer id;

  GroupDto group;

  String name;

  String email;

  String phone;

}
