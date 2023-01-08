package com.example.web.controller.dto.mapper;

import com.example.web.controller.dto.GroupDto;
import com.example.web.model.Group;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroupDtoMapper {

  DepartmentDtoMapper departmentDtoMapper;

  public GroupDto toDto(Group entity){
    if (entity== null) return null;
    return GroupDto.builder()
        .id(entity.getId())
        .department(departmentDtoMapper.toDto(entity.getDepartment()))
        .name(entity.getName())
        .course(entity.getCourse())
        .build();
  }

  public List<GroupDto> toDtoList(List<Group> entities){
    return entities.stream()
        .map(this::toDto)
        .toList();
  }

  public Group toEntity(GroupDto dto){
    return Group.builder()
        .id(dto.getId())
//        .department(departmentDtoMapper.toEntity(dto.getDepartment()))
        .name(dto.getName())
        .course(dto.getCourse())
        .build();
  }
}
