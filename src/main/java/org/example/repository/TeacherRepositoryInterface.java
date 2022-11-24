package org.example.repository;

import org.example.model.Student;
import org.example.model.Teacher;

import java.util.ArrayList;

public interface TeacherRepositoryInterface {

    public void add(Teacher teacher);
    public ArrayList<Teacher> findALl();
    public ArrayList<Teacher> findAllByStudent(Student student);
    public Teacher findByName(String name);
    public Teacher findBySurname(String surname);
}
