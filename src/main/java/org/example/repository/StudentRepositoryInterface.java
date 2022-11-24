package org.example.repository;

import org.example.model.Student;
import org.example.model.Teacher;

import java.util.ArrayList;

public interface StudentRepositoryInterface {

    public void add(Student student);
    public ArrayList<Student> findAll ();
    public ArrayList<Student> findAllByTeacher(Teacher teacher);
    public ArrayList<Student> findByName(String name);
    public ArrayList<Student> findBySurname(String surname);
    public ArrayList<Student> findByEmail(String email);
}
