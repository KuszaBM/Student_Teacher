package org.example;

import org.example.repository.InMemoryStudentRepository;
import org.example.repository.InMemoryTeacherRepository;
import org.example.service.StudentService;
import org.example.service.TeacherService;
import org.example.userInterface.UserInterfaceFactory;

public class Main {
    public static void main(String[] args) {
        UserInterfaceFactory fc = new UserInterfaceFactory(
                new StudentService(new InMemoryStudentRepository()),
                new TeacherService(new InMemoryTeacherRepository())
        );
        fc.createMainInterface().printAndRun();
    }
}