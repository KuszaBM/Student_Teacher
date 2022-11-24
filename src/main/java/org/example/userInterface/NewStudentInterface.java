package org.example.userInterface;

import org.example.model.Student;
import org.example.service.StudentService;

import java.util.Arrays;

public class NewStudentInterface extends UserInterface {
    public static final String NAME = "NEW_STUDENT";
    private final StudentService studentService;
    private Student newStudent;
    private boolean[] isSet;

    public NewStudentInterface(StudentService studentService) {
        super();
        this.studentService = studentService;
        isSet = new boolean[5];
        Arrays.fill(isSet, Boolean.FALSE);
        this.interfaceOptions.put(1, "Name: " + "n/a");
        this.interfaceOptions.put(2, "Surname: "+ "n/a");
        this.interfaceOptions.put(3, "Age: "+ "n/a");
        this.interfaceOptions.put(4, "Email: " + "n/a");
        this.interfaceOptions.put(5, "Field of Study: "+ "n/a");
        this.interfaceOptions.put(6, "Add student");
        this.interfaceOptions.put(0, "back");
        this.newStudent = new Student();
    }

    @Override
    public void execute(int input) {
        switch (input) {
            case 1: {
                System.out.println("Enter Student name");
                String name = inputRequest();
                if(isValidName(name)) {
                    newStudent.setName(name);
                    interfaceOptions.replace(1, "Name: " + name);
                    isSet[0] = true;
                } else {
                    System.out.println("Invalid name");
                }
                break;
            }
            case 2: {
                System.out.println("Enter Student surname");
                String surname = inputRequest();
                if(isValidName(surname)) {
                    newStudent.setSurname(surname);
                    interfaceOptions.replace(2, "Surname: " + surname);
                    isSet[1] = true;
                } else {
                    System.out.println("Invalid surname");
                }
                break;
            }
            case 3: {
                System.out.println("Enter Student age");
                String age = inputRequest();
                if(isCorrectAge(age)) {
                    newStudent.setAge(Integer.parseInt(age));
                    interfaceOptions.replace(3, "Age: " + age);
                    isSet[2] = true;
                } else {
                    System.out.println("Invalid age");
                }
                break;
            }
            case 4: {
                System.out.println("Enter Student email");
                String email = inputRequest();
                if(isCorrectEmail(email)) {
                    newStudent.setEmail(email);
                    interfaceOptions.replace(4, "Email: " + email);
                    isSet[3] = true;
                } else {
                    System.out.println("Invalid email");
                }
                break;
            }
            case 5: {
                System.out.println("Enter Field of Study");
                String field = inputRequest();
                if(isValidName(field)) {
                    newStudent.setFieldOfStudy(field);
                    interfaceOptions.replace(5, "Field of Study: " + field);
                    isSet[4] = true;
                } else {
                    System.out.println("Invalid surname");
                }
                break;
            }
            case 6: {
                for (int i = 0; i < 5; i++) {
                    if (isSet[i] = false){
                        System.out.println("You have to give all student data");
                        return;
                    }
                }
                studentService.addStudent(newStudent);
                newStudent = new Student();
                System.out.println("Student has been added!");
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

    public boolean isCorrectAge(String input) {
        int age = Integer.parseInt(input);
        if(age > 18) {
            return true;
        }
        return false;
    }

    private boolean isCorrectEmail(String inputString) {
        boolean isCorrect = false;
        String emailRegex  = "^[A-Za-z0-9.]+@[A-Za-z0-9]+\\.[a-zA-Z0-9]+$";
        if (inputString.matches(emailRegex)) {
            isCorrect = true;
        }
        return isCorrect;
    }

    public boolean isValidName(String inputString) {
        boolean isCorrect = true;
        char[] inputArray = inputString.toCharArray();
        if(isEnglishLetter(inputArray[0])
                && isEnglishLetter(inputArray[inputString.length()-1])
                && inputString.length() > 1)
        {
            for (int i = 1; i < inputString.length() - 1; i++)
            {
                if(isEnglishLetter(inputArray[i])
                        || isValidCharacter(inputArray[i]))
                {
                    if(isValidCharacter(inputArray[i])
                            && isValidCharacter(inputArray[i+1]))
                    {
                        isCorrect = false;
                        break;
                    } else if (isEnglishLetterUpper(inputArray[i])
                            && !isValidCharacter(inputArray[i-1])) {
                        isCorrect = false;
                        break;
                    }
                } else {
                    isCorrect = false;
                    break;
                }
            }
        } else {
            isCorrect = false;
        }
        return isCorrect;
    }
    private boolean isEnglishLetterUpper(char inputCharacter) {
        return inputCharacter >= 65 && inputCharacter <= 90;

    }
    private boolean isEnglishLetterLower(char inputCharacter){
        return inputCharacter >= 97 && inputCharacter <= 122;
    }
    private boolean isValidCharacter(char inputCharacter) {
        return inputCharacter == 39 || inputCharacter == 45;
    }

    private boolean isEnglishLetter(char inputCharacter) {
        if(isEnglishLetterUpper(inputCharacter)
                || isEnglishLetterLower(inputCharacter)) {
            return true;
        } else {
            return false;
        }
    }
}

