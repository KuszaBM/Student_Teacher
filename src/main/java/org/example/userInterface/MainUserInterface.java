package org.example.userInterface;

public class MainUserInterface extends UserInterface{
    public static final String NAME = "MAIN";
    public final UserInterfaceFactory userInterfaceFactory;
    public MainUserInterface(UserInterfaceFactory userInterfaceFactory) {
        super();
        this.userInterfaceFactory = userInterfaceFactory;
        this.interfaceOptions.put(1, "List All Students");
        this.interfaceOptions.put(2, "List All Teachers");
        this.interfaceOptions.put(3, "Add new student/teacher");
        this.interfaceOptions.put(0, "Exit");
    }
    @Override
    public void execute(int input) {
        switch (input) {
            case 1: {
                userInterfaceFactory.createPrintAllStudentsInterface(0, 2, userInterfaceFactory.passInfoAboutRep()).printAndRun();
                break;
            }
            case 2: {
                userInterfaceFactory.createPrintAllTeachersInterface().printAndRun();
                break;
            }
            case 3: {
                userInterfaceFactory.createAddStudentOrTeacherInterface().printAndRun();
                break;
            }
            case 0: {
                exit();
            }
            default: {
                break;
            }
        }
    }

    public void exit() {

    }
    @Override
    public void printAndRun() {
        System.out.println("To edit student/teacher choose one from the list of students/teacher");
        super.printAndRun();
    }
}
