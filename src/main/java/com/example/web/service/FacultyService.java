package com.example.web.service;

import com.example.web.exception.FacultyNotFoundException;
import com.example.web.model.Faculty;
import com.example.web.repository.FacultyRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class FacultyService {

  FacultyRepository repository;

  public List<Faculty> getAll() {
    return repository.findAll();
  }

  public Faculty getByIdOrThrowException(Integer facultyId) {
    return getOrElseThrow(facultyId);
  }

  public Faculty create(Faculty faculty) {
    return repository.save(faculty);
  }

  public Faculty edit(Faculty faculty, Integer facultyId) {
    Faculty facultyFromDb = getOrElseThrow(facultyId);
    facultyFromDb.setName(faculty.getName());
    facultyFromDb.setShortName(faculty.getShortName());
    return repository.save(facultyFromDb);
  }

  public void delete(Integer facultyId) {
    repository.deleteById(facultyId);
  }

  private Faculty getOrElseThrow(Integer facultyId) {
    return repository.findById(facultyId)
        .orElseThrow(() -> new FacultyNotFoundException(
            String.format("Faculty with id %s does not exist", facultyId)));
  }

}
