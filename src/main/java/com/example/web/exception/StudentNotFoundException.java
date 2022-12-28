package com.example.web.exception;

public class StudentNotFoundException extends RuntimeException {


  public StudentNotFoundException(String message) {
    super(message);
  }
}
