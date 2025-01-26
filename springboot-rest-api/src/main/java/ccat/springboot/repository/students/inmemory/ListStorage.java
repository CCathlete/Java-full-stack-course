package ccat.springboot.repository.students.inmemory;

import java.util.ArrayList;
import java.util.List;

import ccat.springboot.bean.Student;

public class ListStorage
        implements ccat.springboot.repository.students.Storage {

    private List<Student> students;

    public ListStorage() {
        this.students = new ArrayList<>();
    }

    // -----------------------------------------------------------------


    public Boolean add(int id, String firstName, String lastName) {

        if (students.contains(students.get(id))) {
            System.out.println("Student with id " + id +
                    " already exists.");
            return false;
        }

        students.add(new Student(id, firstName, lastName));
        return true;

    }

    // -----------------------------------------------------------------


    // This needs fixing. We need to search the entire list for the id since
    // the student id doesn't necessarily corresponds to the index in the list.
    public Student get(int id) {

        return students.get(id);

    }

    // -----------------------------------------------------------------


    public Boolean delete(int id) {

        Student removedEntry = students.remove(id);

        if (students.get(removedEntry.getId()) != null) {
            System.out.println("There was an error deleting student with id " + id);
            return false;
        }

        return true;

    }

    // -----------------------------------------------------------------


    public Boolean update(int id, String firstName, String lastName) {

        Student student = students.get(id);

        if (student != null) {
            if (!firstName.isBlank())
                student.setFirstName(firstName);

            if (!lastName.isBlank())
                student.setLastName(lastName);
        } else {
            System.out.println("Student with id " + id + " not found.");
            return false;
        }

        return true;

    }

    // -----------------------------------------------------------------


    public Boolean clear() {

        return true;
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
