package org.example.userInterface;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.StudentService;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PrintAllStudentsInterface extends UserInterface {

    public static final String NAME = "PRINT_ALL_STUDENTS";
    private int atOnce;
    private int sitesAmount;
    private boolean hasNext;
    private boolean hasPrevious;
    private int site;
    private final UserInterfaceFactory userInterfaceFactory;
    private final StudentService studentService;

    private ArrayList<Student> toPrint;

    public PrintAllStudentsInterface(UserInterfaceFactory userInterfaceFactory,
                                     StudentService studentService,
                                     int site,
                                     int atOnce,
                                     ArrayList<Student> toPrint) {
        super();
        this.toPrint = toPrint;
        this.atOnce = atOnce;
        this.site = site;
        this.userInterfaceFactory = userInterfaceFactory;
        this.studentService = studentService;
        this.sitesAmount = studentService.findAll().size()/atOnce + 1;
        this.hasNext = hasNext();
        this.hasPrevious = hasPrevious();

        this.interfaceOptions.put(1, "More options");
        if(hasNext) {
            this.interfaceOptions.put(2, "Next");
        }
        if(hasPrevious) {
            this.interfaceOptions.put(3, "Previous");
        }
        this.interfaceOptions.put(0, "Back to main");

        ArrayList<Student> tempStudents = toPrint;
        for(int i = 0; i < atOnce; i++) {

            if(i + site*atOnce < tempStudents.size()) {
                Student tempStudent = tempStudents.get(i + site*atOnce);
                this.interfaceOptions.put(i + 4 + site*atOnce,
                        tempStudent.getName()
                                + " "
                                + tempStudent.getSurname()
                                + " "
                                + tempStudent.getEmail());
            }
        }
    }

    @Override
    public void execute(int input) {
        if(input < 4) {
            switch (input) {
                case 2: {
                    userInterfaceFactory.createPrintAllStudentsInterface(
                            this.site + 1,
                            this.atOnce, this.toPrint).printAndRun();
                    break;
                }
                case 3: {
                    userInterfaceFactory.createPrintAllStudentsInterface(
                            this.site - 1,
                            this.atOnce, this.toPrint).printAndRun();
                    break;
                }
                case 1: {
                    moreOptions();
                    break;
                }
                case 0: {
                    exit();
                }
                default: {
                    break;
                }
            }

        } else {

        }
    }

    public void exit() {

    }
    public void reInitMap(int atOnce) {

        this.interfaceOptions.clear();
        this.sitesAmount = studentService.findAll().size()/atOnce + 1;
        this.hasNext = hasNext();
        this.hasPrevious = hasPrevious();

        this.interfaceOptions.put(1, "More options");
        if(hasNext) {
            this.interfaceOptions.put(2, "Next");
        }
        if(hasPrevious) {
            this.interfaceOptions.put(3, "Previous");
        }
        this.interfaceOptions.put(0, "Back to main");

        ArrayList<Student> tempStudents = toPrint;
        for(int i = 0; i < atOnce; i++) {

            if(i + site*atOnce < tempStudents.size()) {
                Student tempStudent = tempStudents.get(i + site*atOnce);
                this.interfaceOptions.put(i + 4 + site*atOnce,
                        tempStudent.getName()
                                + " "
                                + tempStudent.getSurname()
                                + " "
                                + tempStudent.getEmail());
            }
        }
    }

    public void setAtOnce(Integer atOnce) {
        this.atOnce = atOnce;
    }

    public void moreOptions() {
        String input = null;
        while (input != "0") {

            System.out.println("1. Sort by name");
            System.out.println("2. Sort by surname");
            System.out.println("3. Sort by email");
            System.out.println("4. Find by teacher");
            System.out.println("5. Find by name");
            System.out.println("6. Find by surname");
            System.out.println("7. Change amount of display record on one site");
            System.out.println("0. Back");
            input = inputRequest();

            switch (Integer.parseInt(input)) {
                case 1: {
                    sortByName();
                    reInitMap(this.atOnce);
                }
                case 2: {
                    sortBySurname();
                    reInitMap(this.atOnce);
                }
                case 3: {
                    sortByEmail();
                    reInitMap(this.atOnce);
                }
                case 4: {
                    findByTeacher();
                    reInitMap(this.atOnce);
                }
                case 5: {
                    String name = inputRequest();
                    toPrint = studentService.findByName(name);
                    reInitMap(this.atOnce);
                }
                case 6: {
                    String surname = inputRequest();
                    toPrint = studentService.findBySurname(surname);
                    reInitMap(this.atOnce);
                }
                case 7: {
                    System.out.println("How much records u want on site");
                    input = inputRequest();
                   int aaa = Integer.parseInt(input);
                    setAtOnce(aaa);
                    reInitMap(this.atOnce);
                    break;
                }
                case 0: {
                    input = "0";
                    exit();
                }
                default: {
                    break;
                }
            }

        }
    }
    public boolean hasNext() {
        if(this.site < sitesAmount - 1) {
            return true;
        }
        return false;
    }

    public void sortByName() {
        this.toPrint = (ArrayList<Student>) toPrint.stream()
                .sorted((o1, o2) -> o1.getName().
                        compareTo(o2.getName()))
                .collect(Collectors.toList());
    }
    public void sortBySurname() {
        this.toPrint = (ArrayList<Student>) toPrint.stream()
                .sorted((o1, o2) -> o1.getSurname().
                        compareTo(o2.getSurname()))
                .collect(Collectors.toList());
    }

    public void sortByEmail() {
        this.toPrint = (ArrayList<Student>) toPrint.stream()
                .sorted((o1, o2) -> o1.getName().
                        compareTo(o2.getName()))
                .collect(Collectors.toList());
    }

    public void findByTeacher() {
        System.out.println("chooseTeacher");
        int counter = 0;
        ArrayList<Teacher> teachers = userInterfaceFactory.passInfoAboutTeachers();
            for(Teacher t : teachers) {
                System.out.println(
                        counter + 1
                        + ". "
                        + t.getName()
                        + " " + t.getSurname());
                counter++;
            }
            String input = inputRequest();
            int choose = Integer.parseInt(input);
            toPrint = studentService.findByTeacher(teachers.get(choose - 1));
    }


    public boolean hasPrevious() {
        if(this.site > 0) {
            return true;
        }
        return false;
    }

}
