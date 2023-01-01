package com.example.web.service;

import com.example.web.exception.DepartmentNotFoundException;
import com.example.web.model.Department;
import com.example.web.repository.DepartmentRepository;
import java.util.List;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DepartmentService {

  DepartmentRepository repository;
  FacultyService facultyService;

  public List<Department> getAll() {
    return repository.findAll();
  }

  public Department getByIdOrThrowException(Integer departmentId) {
    return getOrElseThrow(departmentId);
  }

  public Department create(Department department, Integer facultyId) {
    department.setFaculty(facultyService.getByIdOrThrowException(facultyId));
    return repository.save(department);
  }

  public Department edit(Department department, Integer departmentId, Integer facultyId) {
    Department departmentFromDb = getOrElseThrow(departmentId);
    departmentFromDb.setFaculty(facultyService.getByIdOrThrowException(facultyId));
    departmentFromDb.setName(department.getName());
    departmentFromDb.setShortName(department.getShortName());
    return repository.save(departmentFromDb);
  }

  public void delete(Integer departmentId) {
    repository.deleteById(departmentId);
  }

  private Department getOrElseThrow(Integer departmentId) {
    return repository.findById(departmentId)
        .orElseThrow(() -> new DepartmentNotFoundException(
            String.format("Department with id %s does not exist", departmentId)));
  }

}
