package com.example.web.service;


import com.example.web.exception.GroupNotFoundException;
import com.example.web.exception.StudentNotFoundException;
import com.example.web.model.Group;
import com.example.web.model.Student;
import com.example.web.repository.GroupRepository;
import com.example.web.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentService {

  StudentRepository repository;
  GroupService groupService;

  public List<Student> getAll() {
    return repository.findAll();
  }

  public Student getByIdOrThrowException(Integer studentId) {
    return getOrElseThrow(studentId);
  }

  public Student create(Student student, Integer groupId)
  {
    student.setGroup(groupService.getByIdOrThrowException(groupId));
    return repository.save(student);
  }

  public Student edit(Student student, Integer studentId, Integer groupId) {
    return Optional.of(getOrElseThrow(studentId))
        .map(newStudent -> {
              newStudent.setName(student.getName());
              newStudent.setGroup(groupService.getByIdOrThrowException(groupId));
              newStudent.setEmail(student.getEmail());
              newStudent.setPhone(student.getPhone());
              return repository.save(newStudent);
            }
          )
        .orElseGet(() -> {
          student.setId(studentId);
          return repository.save(student);
        });
  }

  public void delete(Integer StudentId) {
    repository.deleteById(StudentId);
  }

  private Student getOrElseThrow(Integer studentId) {
    return repository.findById(studentId)
        .orElseThrow(() -> new StudentNotFoundException(
            String.format("Student with id %s does not exist", studentId)));
  }

}
