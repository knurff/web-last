package com.example.web.repository;

import com.example.web.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Set<Department> findAllByFacultyId(Integer facultyId);
}
