package ccat.springboot.repository.students.inmemory;

import java.util.HashMap;
import java.util.Map;

import ccat.springboot.bean.Student;

public class MapStorage
        implements ccat.springboot.repository.students.Storage {

    private Map<Integer, Student> students;

    public MapStorage() {
        this.students = new HashMap<>();
    }

    // -----------------------------------------------------------------


    public Boolean add(int id, String firstName, String lastName) {

        if (students.containsKey(id)) {
            System.out.println("Student with id " + id +
                    " already exists.");
            return false;
        }

        students.put(id, new Student(id, firstName, lastName));
        return true;

    }

    // -----------------------------------------------------------------


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
            System.out.println("Update: Student with id "
                    + id + " not found.");
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
