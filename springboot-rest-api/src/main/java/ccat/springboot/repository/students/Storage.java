package ccat.springboot.repository.students;

import ccat.springboot.bean.Student;

public interface Storage {

    public void add(int id, String firstName, String lastName);

    public Student get(int id);

    public void delete(int id);

    public void update(int id, String firstName, String lastName);

    public void clear();

    public void printAll();

    public void printKeys();

    public void printSize();

}
