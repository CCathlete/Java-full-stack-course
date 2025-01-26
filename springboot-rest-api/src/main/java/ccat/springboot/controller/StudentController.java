package ccat.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ccat.springboot.bean.Student;
import ccat.springboot.repository.students.Storage;
import ccat.springboot.repository.students.inmemory.MapStorage;

@RestController
public class StudentController {

        private Storage storage;

        public StudentController() {
                // This implementation of storage can change later since Storage is an
                // interface.
                this.storage = new MapStorage();
                this.storage.add(
                                1,
                                "John",
                                "Doe");
        }


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

                Student student = this.storage.get(studentId);
                if (!student.getFirstName().equals(firstName))
                        return null;
                if (!student.getLastName().equals(lastName))
                        return null;

                return student;
        }

        // Spring boot api with request params.


        @GetMapping("/students/query")
        public Student studentRequestVariable(
                        @RequestParam("id") int studentId,
                        @RequestParam("firstName") String studentFirstName,
                        @RequestParam("lastName") String studentLastName) {

                Student student = this.storage.get(studentId);
                if (student.getFirstName().equals(studentFirstName))
                        return null;
                if (student.getLastName().equals(studentLastName))
                        return null;

                return student;
        }

        // Spring boot api that handles HTTP POST requests.


        @PostMapping("/students/create")
        @ResponseStatus(code = HttpStatus.CREATED)
        public Student createStudent(@RequestBody Student student) {
                int id = student.getId();
                if (this.storage.get(id) != null) {
                        System.out.println("Student with id " + id
                                        + " already exists.");
                        return null;
                }

                this.storage.add(
                                id,
                                student.getFirstName(),
                                student.getLastName());

                Student entry = this.storage.get(student.getId());
                if (entry != null) {
                        System.out.println("Student created.");
                }

                return entry;
        }

        // Spring boot api that handles HTTP put requests.


        @PutMapping("/students/update")
        public Student updateStudent(@RequestBody Student student) {

                int id = student.getId();
                String firstName = student.getFirstName();
                String lastName = student.getLastName();

                Student oldEntry = this.storage.get(id);
                if (oldEntry == null) {
                        System.out.println("Student with id "
                                        + id + " doesn't exist.");
                        return null;
                }
                this.storage.update(id, firstName, lastName);

                return student;
        }
}

// Spring boot api that handles HTTP delete requests.