package com.example.web.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionResponse {

    private String errorCode;
    private String errorMessage;

}
