package org.example.userInterface;

import org.example.service.StudentService;

public class MoreOptionsInterface extends UserInterface{
    public static final String NAME = "MORE OPTIONS";
    private final UserInterfaceFactory userInterfaceFactory;
    private final StudentService studentService;

    public MoreOptionsInterface(UserInterfaceFactory userInterfaceFactory, StudentService studentService) {
        super();
        this.userInterfaceFactory = userInterfaceFactory;
        this.studentService = studentService;
        this.interfaceOptions.put(1, "More options");
        this.interfaceOptions.put(2, "Next");
        this.interfaceOptions.put(3, "Back");
    }
    @Override
    public void execute(int input) {
        if(input < 4) {
            switch (input) {
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
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
    }
    public void exit() {

    }
}
