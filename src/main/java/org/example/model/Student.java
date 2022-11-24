package org.example.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Student {
    private  String name;
    private  String surname;
    private  String email;
    private  int age;
    private String fieldOfStudy;
    private LinkedList<Teacher> teachers;
    public Student() {}

    public Student(String name, String surname, String email, int age, String fieldOfStudy) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.fieldOfStudy = fieldOfStudy;
        this.teachers = new LinkedList<>();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }
    public boolean hasTeacher(Teacher teacher) {
        for(Teacher t : teachers) {
            if(t.equals(teacher)) {
                return true;
            }
        }
        return false;
    }
    public boolean equals(Student student) {
        return this.toString().equals(student.toString());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                '}';
    }

    public LinkedList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(LinkedList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

}
