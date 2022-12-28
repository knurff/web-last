package com.example.web.service;

import com.example.web.exception.DisciplineNotFoundException;
import com.example.web.model.Discipline;
import com.example.web.repository.DisciplineRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DisciplineService {

  DisciplineRepository repository;

  public List<Discipline> getAll() {
    return repository.findAll();
  }

  public Discipline getByIdOrThrowException(Integer disciplineId) {
    return getOrElseThrow(disciplineId);
  }

  public Discipline create(Discipline discipline) {
    return repository.save(discipline);
  }

  public Discipline edit(Discipline discipline, Integer disciplineId) {
    Discipline disciplineFromDb = getOrElseThrow(disciplineId);
    disciplineFromDb.setName(discipline.getName());
    return repository.save(discipline);
  }

  public void delete(Integer disciplineId) {
    repository.deleteById(disciplineId);
  }

  private Discipline getOrElseThrow(Integer disciplineId) {
    return repository.findById(disciplineId)
        .orElseThrow(() -> new DisciplineNotFoundException(
            String.format("Discipline with id %s does not exist", disciplineId)));
  }

}
