package com.example.web.repository;

import com.example.web.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Set<Student> findAllByGroupId(Integer groupId);
}
