package org.example.repository;

import org.example.model.Student;
import org.example.model.Teacher;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InMemoryStudentRepository implements StudentRepositoryInterface {

    private ArrayList<Student> students;

    public InMemoryStudentRepository() {
        students = new ArrayList<>();
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public ArrayList<Student> findAll() {
        return students;
    }

    @Override
    public ArrayList<Student> findAllByTeacher(Teacher teacher) {
        return (ArrayList<Student>) findAll().stream()
                .filter(s -> s.hasTeacher(teacher))
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<Student> findByName(String name) {
        return (ArrayList<Student>) findAll().stream()
                .filter(s -> s.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<Student> findBySurname(String surname) {
        return (ArrayList<Student>) findAll().stream()
                .filter(s -> s.getSurname().equals(surname))
                .collect(Collectors.toList());
    }
    public ArrayList<Student> findByEmail(String email) {
        return (ArrayList<Student>) findAll().stream()
                .filter(s -> s.getEmail().equals(email))
                .collect(Collectors.toList());
    }
}
