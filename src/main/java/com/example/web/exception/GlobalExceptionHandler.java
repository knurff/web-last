package com.example.web.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String DEPARTMENT_NOT_FOUND = "department_not_found";
    private static final String DISCIPLINE_NOT_FOUND = "discipline_not_found";
    private static final String FACULTY_NOT_FOUND = "faculty_not_found";
    private static final String GROUP_NOT_FOUND = "group_not_found";
    private static final String SCHEDULE_NOT_FOUND = "schedule_not_found";
    private static final String STUDENT_NOT_FOUND = "student_not_found";
    private static final String TEACHER_NOT_FOUND = "teacher_not_found";


    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> departmentNotFoundException(
            DepartmentNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(DEPARTMENT_NOT_FOUND, e.getMessage()),
                HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> disciplineNotFoundException(
            DisciplineNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(DISCIPLINE_NOT_FOUND, e.getMessage()),
                HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> facultyNotFoundException(
            FacultyNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(FACULTY_NOT_FOUND, e.getMessage()),
                HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> groupNotFoundException(
            GroupNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(GROUP_NOT_FOUND, e.getMessage()),
                HttpStatus.NOT_FOUND);
    }





    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> scheduleNotFoundException(
            ScheduleNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(SCHEDULE_NOT_FOUND, e.getMessage()),
                HttpStatus.NOT_FOUND);
    }




    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> studentNotFoundException(
            StudentNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(STUDENT_NOT_FOUND, e.getMessage()),
                HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<ExceptionResponse> teacherNotFoundException(
            TeacherNotFoundException e) {
        return new ResponseEntity<>(new ExceptionResponse(TEACHER_NOT_FOUND, e.getMessage()),
                HttpStatus.NOT_FOUND);
    }


}
