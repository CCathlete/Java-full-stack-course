package ccat.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ccat.springboot.bean.Student;
import ccat.springboot.controller.exceptions.StudentAlreadyExistsException;
import ccat.springboot.controller.exceptions.StudentNotDeletedException;
import ccat.springboot.controller.exceptions.StudentNotFoundException;
import ccat.springboot.repository.students.Storage;
import ccat.springboot.repository.students.inmemory.MapStorage;

@RestController
@RequestMapping("students")
public class StudentController {

        private Storage storage;

        public StudentController() {
                // This implementation of storage can change later since Storage is an
                // interface.
                this.storage = new MapStorage();
                this.storage.add(1, "John", "Doe");
        }


        @GetMapping("example-student")
        public ResponseEntity<Student> getStudent() {
                Student student = new Student(1, "John", "Doe");

                return ResponseEntity.status(HttpStatus.OK).body(student);
        }


        @GetMapping("example-list")
        public ResponseEntity<List<Student>> getStudents() {
                List<Student> students = List.of(new Student(1, "John", "Doe"), new Student(2, "Jane", "Doe"),
                                new Student(3, "Jack", "Doe"));

                return ResponseEntity.status(HttpStatus.OK).body(students);
        }


        // Spring boot api with a path variable.
        @GetMapping("{id}/{first-name}/{last-name}")
        public ResponseEntity<?> studentPathVariable(@PathVariable("id") int studentId,
                        @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {

                Student student = this.storage.get(studentId);
                // Alternative to creating exceptions.
                if (!student.getFirstName().equals(firstName))
                        return ResponseEntity.status(HttpStatus.CONFLICT).body("First name incorrect.");

                if (!student.getLastName().equals(lastName))
                        return ResponseEntity.status(HttpStatus.CONFLICT).body("Last name incorrect.");

                return ResponseEntity.ok(student);
        }

        // Spring boot api with request params.


        @GetMapping(value = "query", params = { "id", "firstName", "lastName" })
        public ResponseEntity<?> studentRequestVariable(@RequestParam("id") int studentId,
                        @RequestParam("firstName") String studentFirstName,
                        @RequestParam("lastName") String studentLastName) {

                Student student = this.storage.get(studentId);
                System.out.println("Student id: " + student.getId());
                System.out.println("Student first name: " + student.getFirstName());
                System.out.println("Student last name: " + student.getLastName());

                if (!student.getFirstName().equals(studentFirstName))
                        return ResponseEntity.status(HttpStatus.CONFLICT).body("First name incorrect.");

                if (!student.getLastName().equals(studentLastName))
                        return ResponseEntity.status(HttpStatus.CONFLICT).body("Last name incorrect.");

                return ResponseEntity.ok(student);
        }

        // Spring boot api that handles HTTP POST requests.


        @PostMapping("create")
        @ResponseStatus(code = HttpStatus.CREATED)
        public ResponseEntity<?> createStudent(@RequestBody Student student) {
                int id = student.getId();
                if (this.storage.get(id) != null) {
                        throw new StudentAlreadyExistsException("Create");
                }

                this.storage.add(id, student.getFirstName(), student.getLastName());

                Student entry = this.storage.get(student.getId());
                if (entry != null) {
                        System.out.println("\nStudent created.\n");
                }

                return ResponseEntity.ok(entry);
        }


        // Spring boot api that handles HTTP put requests.
        @PutMapping("update")
        public ResponseEntity<?> updateStudent(@RequestBody Student student) {

                int id = student.getId();
                String firstName = student.getFirstName();
                String lastName = student.getLastName();

                Boolean ok = this.storage.update(id, firstName, lastName);
                if (!ok) {
                        throw new StudentNotFoundException("Update");
                }

                // If ok, the updated student will look like our input.
                return ResponseEntity.ok(student);
        }


        // Spring boot api that handles HTTP delete requests.
        @DeleteMapping("delete/{id}")
        public ResponseEntity<?> deleteStudent(@PathVariable("id") int studentId) {

                Boolean ok = this.storage.delete(studentId);
                if (!ok) {
                        throw new StudentNotDeletedException("Delete");
                }

                return ResponseEntity.ok("Student with id " + studentId + " deleted.");
        }
}