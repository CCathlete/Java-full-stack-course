package ccat.springboot.controller.exceptions;

public class StudentAlreadyExistsException extends RuntimeException {

    public StudentAlreadyExistsException(String funcName) {

        super(funcName + ": " + "Student already exists in storage.");

    }

}
