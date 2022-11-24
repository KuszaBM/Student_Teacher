package org.example.userInterface;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.StudentService;
import org.example.service.TeacherService;

import java.util.ArrayList;

public class UserInterfaceFactory {

    private final StudentService studentService;
    private final TeacherService teacherService;


    public UserInterfaceFactory(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }


    public UserInterface create(String type) {
        switch (type) {
            case MainUserInterface.NAME:
                return this.createMainInterface();
            case EditStudentInterface.NAME:
           //     return this.createEntityInterface();
            case NewStudentInterface.NAME:
                return this.createNewStudentInterface();
            case NewTeacherInterface.NAME:
                return this.createNewTeacherInterface();
            case PrintAllStudentsInterface.NAME:
               // return this.createPrintAllStudentsInterface();
            case PrintAllTeachersInterface.NAME:
                return this.createPrintAllTeachersInterface();
            case AddStudentOrTeacherInterface.NAME:
                return this.createAddStudentOrTeacherInterface();

            default:
                return new NokInterface();
        }
    }

    public MainUserInterface createMainInterface() {
        return new MainUserInterface(this);
    }

    public EditStudentInterface createEntityInterface(StudentService studentService, int index) {
        return new EditStudentInterface(studentService, index);
    }

    public NewStudentInterface createNewStudentInterface() {
        return new NewStudentInterface(studentService);
    }

    public NewTeacherInterface createNewTeacherInterface() {
        return new NewTeacherInterface(teacherService);
    }
    public PrintAllTeachersInterface createPrintAllTeachersInterface() {
        return new PrintAllTeachersInterface();
    }
    public PrintAllStudentsInterface createPrintAllStudentsInterface(int site, int atOnce, ArrayList<Student> toPrint) {
        return new PrintAllStudentsInterface(this, studentService, site, atOnce, toPrint );
    }
    public AddStudentOrTeacherInterface createAddStudentOrTeacherInterface() {
        return new AddStudentOrTeacherInterface(this);
    }

    public MoreOptionsInterface createMoreOptionsInterface() {
        return new MoreOptionsInterface(this, this.studentService);
    }

    public ArrayList<Student> passInfoAboutRep() {
        return studentService.findAll();
    }
    public ArrayList<Teacher> passInfoAboutTeachers() {
        return teacherService.teacherRepository.findALl();
    }



}
