package ccat.springboot.repository.students.inmemory;

import java.util.List;

import ccat.springboot.bean.Student;

public class ListStorage
        implements ccat.springboot.repository.students.Storage {

    private List<Student> students;

    public void add(int id, String firstName, String lastName) {

        students.add(new Student(id, firstName, lastName));

    }

    // -----------------------------------------------------------------

    public Student get(int id) {

        return students.get(id);

    }

    // -----------------------------------------------------------------

    public void delete(int id) {

        students.remove(id);

    }

    // -----------------------------------------------------------------

    public void update(int id, String firstName, String lastName) {

        Student student = students.get(id);

        if (student != null) {
            if (firstName != null && !firstName.isEmpty())
                student.setFirstName(firstName);

            if (lastName != null && !lastName.isEmpty())
                student.setLastName(lastName);
        } else {
            System.out.println("Student with id " + id + " not found.");
        }

    }

    // -----------------------------------------------------------------

    public void clear() {
    }

    // -----------------------------------------------------------------

    public void printAll() {
    }

    // -----------------------------------------------------------------

    public void printKeys() {
    }

    // -----------------------------------------------------------------

    public void printSize() {
    }

}
