package ccat.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ccat.springboot.bean.Student;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        return new Student(
                1,
                "John",
                "Doe");
    }

}
