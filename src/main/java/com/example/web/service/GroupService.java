package com.example.web.service;


import com.example.web.exception.GroupNotFoundException;
import com.example.web.model.Group;
import com.example.web.repository.GroupRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GroupService {

  GroupRepository repository;

  public List<Group> getAll() {
    return repository.findAll();
  }

  public Group getByIdOrThrowException(Integer groupId) {
    return getOrElseThrow(groupId);
  }

  public Group create(Group group) {
    return repository.save(group);
  }

  public Group edit(Group group, Integer groupId) {
    Group groupFromDb = getOrElseThrow(groupId);
    groupFromDb.setDepartment(group.getDepartment());
    groupFromDb.setName(group.getName());
    groupFromDb.setCourse(group.getCourse());
    return repository.save(group);
  }

  public void delete(Integer groupId) {
    repository.deleteById(groupId);
  }

  private Group getOrElseThrow(Integer groupId) {
    return repository.findById(groupId)
        .orElseThrow(() -> new GroupNotFoundException(
            String.format("Group with id %s does not exist", groupId)));
  }

}
