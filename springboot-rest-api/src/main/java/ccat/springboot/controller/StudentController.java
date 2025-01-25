package ccat.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("/students-list")
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1,
                        "John",
                        "Doe"),
                new Student(
                        2,
                        "Jane",
                        "Doe"),
                new Student(
                        3,
                        "Jack",
                        "Doe"));
    }

    // Spring boot api with a path variable.

    @GetMapping("/students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(
            @PathVariable("id") int studentId,
            @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName) {

        return new Student(
                studentId,
                firstName,
                lastName);
    }

    // Spring boot api with request params.

    @GetMapping("/students/query")
    public Student studentRequestVariable(
            @RequestParam("id") int studentId,
            @RequestParam("firstName") String studentFirstName,
            @RequestParam("lastName") String studentLastName) {

        return new Student(
                studentId,
                studentFirstName,
                studentLastName);
    }

    // Spring boot api that handles HTTP POST request.

    @PostMapping("/students/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

}
