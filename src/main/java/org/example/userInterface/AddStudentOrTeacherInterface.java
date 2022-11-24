package org.example.userInterface;

public class AddStudentOrTeacherInterface extends UserInterface {
    public static final String NAME = "AddStudentOrTeacher";
    public final UserInterfaceFactory userInterfaceFactory;
    public AddStudentOrTeacherInterface(UserInterfaceFactory userInterfaceFactory) {
        super();
        this.userInterfaceFactory = userInterfaceFactory;
        this.interfaceOptions.put(1, "Student");
        this.interfaceOptions.put(2, "Teacher");
        this.interfaceOptions.put(0, "back");
    }

    @Override
    public void execute(int input) {
        switch (input) {
            case 1: {
                userInterfaceFactory.createNewStudentInterface().printAndRun();
                break;
            }
            case 2: {
                userInterfaceFactory.createNewTeacherInterface().printAndRun();
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
        System.out.println("Who You want to add?");
        super.printAndRun();
    }
}
