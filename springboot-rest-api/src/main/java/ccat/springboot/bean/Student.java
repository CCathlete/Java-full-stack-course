package ccat.springboot.bean;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String firstName;
    private String lastName;

    // To fully adhere to JavaBean conventions, we need to have an empty
    // constructor.
    public Student() {
    }

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLasttName() {
        return this.lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLasttName(String lastName) {
        this.lastName = lastName;
    }

}
