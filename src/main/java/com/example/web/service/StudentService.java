package com.example.web.service;


import com.example.web.exception.StudentNotFoundException;
import com.example.web.model.Student;
import com.example.web.repository.StudentRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class StudentService {

  StudentRepository repository;

  public List<Student> getAll() {
    return repository.findAll();
  }

  public Student getByIdOrThrowException(Integer studentId) {
    return getOrElseThrow(studentId);
  }

  public Student create(Student student) {
    return repository.save(student);
  }

  public Student edit(Student student, Integer studentId) {
    Student studentFromDb = getOrElseThrow(studentId);
    studentFromDb.setName(student.getName());
    studentFromDb.setGroup(student.getGroup());
    studentFromDb.setEmail(student.getEmail());
    studentFromDb.setPhone(student.getPhone());
    return repository.save(student);
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
