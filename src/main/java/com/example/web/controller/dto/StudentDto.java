package com.example.web.controller.dto;

import com.example.web.model.Group;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

  Integer id;

  GroupDto group;


  @JsonProperty(access = Access.WRITE_ONLY)
  Integer groupId;

  String name;

  String email;

  String phone;

}
