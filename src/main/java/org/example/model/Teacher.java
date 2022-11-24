package org.example.model;

import java.util.LinkedList;

public class Teacher{
    private  String name;
    private  String surname;
    private  String email;
    private  int age;
    private String studySubject;
    private LinkedList<Student> students;

    public Teacher(){}

    public Teacher(String name, String surname, String email, int age, String studySubject) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.studySubject = studySubject;
        this.students = new LinkedList<>();
    }
    public boolean hasStudent(Student student) {
        for(Student s : students) {
            if (s.equals(student)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Teacher teacher) {
        return this.toString().equals(teacher.toString());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", studySubject='" + studySubject + '\'' +
                '}';
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }
}
