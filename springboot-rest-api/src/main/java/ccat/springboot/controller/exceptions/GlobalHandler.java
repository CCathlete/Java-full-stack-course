package ccat.springboot.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException e) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                e.getMessage());

    }


    @ExceptionHandler(StudentAlreadyExistsException.class)
    public ResponseEntity<String> handleStudentStudentAlreadyExists(StudentAlreadyExistsException e) {

        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                e.getMessage());

    }

}
