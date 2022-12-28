package com.example.web.exception;

public class GroupNotFoundException extends RuntimeException {

  public GroupNotFoundException(String message) {
    super(message);
  }
}
