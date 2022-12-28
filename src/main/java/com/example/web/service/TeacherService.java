package com.example.web.service;


import com.example.web.exception.TeacherNotFoundException;
import com.example.web.model.Teacher;
import com.example.web.repository.TeacherRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TeacherService {

  TeacherRepository repository;

  public List<Teacher> getAll() {
    return repository.findAll();
  }

  public Teacher getByIdOrThrowException(Integer teacherId) {
    return getOrElseThrow(teacherId);
  }

  public Teacher create(Teacher Teacher) {
    return repository.save(Teacher);
  }

  public Teacher edit(Teacher teacher, Integer TeacherId) {
    Teacher teacherFromDb = getOrElseThrow(TeacherId);
    teacherFromDb.setName(teacher.getName());
    teacherFromDb.setSurname(teacher.getSurname());
    teacherFromDb.setEmail(teacher.getEmail());
    teacherFromDb.setPhone(teacher.getPhone());
    return repository.save(teacher);
  }

  public void delete(Integer teacherId) {
    repository.deleteById(teacherId);
  }

  private Teacher getOrElseThrow(Integer teacherId) {
    return repository.findById(teacherId)
        .orElseThrow(() -> new TeacherNotFoundException(
            String.format("Teacher with id %s does not exist", teacherId)));
  }

}
