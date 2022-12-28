package com.example.web.exception;

public class TeacherNotFoundException extends RuntimeException {

  public TeacherNotFoundException(String message) {
    super(message);
  }
}
