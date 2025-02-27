package ccat.springboot.repository.students;

import ccat.springboot.bean.Student;

public interface Storage {

    public Boolean add(int id, String firstName, String lastName);


    public Student get(int id);


    public Boolean delete(int id);


    public Boolean update(int id, String firstName, String lastName);


    public Boolean clear();


    public void printAll();


    public void printKeys();


    public void printSize();

}
