package ccat.springboot.controller.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String funcName) {

        super(funcName + ": " + "Student not found in storage.");

    }

}
