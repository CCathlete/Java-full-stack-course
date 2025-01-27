package ccat.springboot.controller.exceptions;

public class StudentNotDeletedException extends RuntimeException {

    public StudentNotDeletedException(String funcName) {
        super(funcName + ": " + "Error when deleting student.");
    }

}
