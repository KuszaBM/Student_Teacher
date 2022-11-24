package org.example.service;

import org.example.model.Teacher;
import org.example.repository.TeacherRepositoryInterface;

public class TeacherService {
    public final TeacherRepositoryInterface teacherRepository;

    public TeacherService(TeacherRepositoryInterface teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public void addTeacher(Teacher teacher){
        this.teacherRepository.add(teacher);
    }


}
