package org.example.repository;

import org.example.model.Student;
import org.example.model.Teacher;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InMemoryTeacherRepository implements TeacherRepositoryInterface {

    private ArrayList<Teacher> teachers;

    public InMemoryTeacherRepository() {
        teachers = new ArrayList<>();
    }

    @Override
    public void add(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public ArrayList<Teacher> findALl() {
        return teachers;
    }

    @Override
    public ArrayList<Teacher> findAllByStudent(Student student) {

        return (ArrayList<Teacher>) findALl().stream()
                .filter(t -> t.hasStudent(student))
                .collect(Collectors.toList());
    }

    @Override
    public Teacher findByName(String name) {
        return null;
    }

    @Override
    public Teacher findBySurname(String surname) {
        return null;
    }
}
