package org.example.repository;

import org.example.model.Student;
import org.example.model.Teacher;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryStudentRepositoryTest {

    public StudentRepositoryInterface studentRepository;
    @BeforeEach
    void setUp() {
        studentRepository = new InMemoryStudentRepository();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAllByTeacher() {
        Teacher teacher1 = new Teacher("michal", "kowalski", "michal@gmail.com", 40, "Economy");
        Teacher teacher3 = new Teacher("karol", "magiczny", "magik@gmail.com", 30, "Data Science");
        Student student1 = new Student("John", "miller", "miJO@pol.com", 21, "It");
        Student student2 = new Student("Johnny", "Jasel", "mijjdO@pol.com", 22, "It");
        Student student3 = new Student("amadeusz", "Harnas", "alberttdO@student.com", 26, "Banking");
        student1.addTeacher(teacher1);
        student1.addTeacher(teacher3);
        student2.addTeacher(teacher1);
        student3.addTeacher(teacher3);

        studentRepository.add(student1);
        studentRepository.add(student2);
        studentRepository.add(student3);

        ArrayList<Student> resultList = studentRepository.findAllByTeacher(teacher1);
        assertEquals(2, resultList.size());
    }
}