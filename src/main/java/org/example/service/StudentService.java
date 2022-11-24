package org.example.service;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repository.StudentRepositoryInterface;

import java.util.ArrayList;

public class StudentService {

    private final StudentRepositoryInterface studentRepository;

    public StudentService(StudentRepositoryInterface studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ArrayList<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
    public ArrayList<Student> findBySurname(String surname) {
        return studentRepository.findBySurname(surname);
    }

    public void addStudent(Student student) {
        studentRepository.add(student);
    }

    public ArrayList<Student> findAll(){
        return studentRepository.findAll();
    }
    public ArrayList<Student> findByTeacher(Teacher teacher) {
        return studentRepository.findAllByTeacher(teacher);
    }

    public void sortByName(ArrayList<Student> students) {
    }


}
