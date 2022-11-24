package org.example.userInterface;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.StudentService;
import org.example.service.TeacherService;

import java.util.Arrays;

public class NewTeacherInterface extends UserInterface {
    public static final String NAME = "NEW_TEACHER";

    private final TeacherService teacherService;
    private Teacher newTeacher;
    private boolean[] isSet;

    public NewTeacherInterface(TeacherService teacherService) {
        super();
        this.teacherService = teacherService;
        isSet = new boolean[5];
        Arrays.fill(isSet, Boolean.FALSE);
        this.interfaceOptions.put(1, "Name: " + "n/a");
        this.interfaceOptions.put(2, "Surname: "+ "n/a");
        this.interfaceOptions.put(3, "Age: "+ "n/a");
        this.interfaceOptions.put(4, "Email: " + "n/a");
        this.interfaceOptions.put(5, "Study Subject: "+ "n/a");
        this.interfaceOptions.put(6, "Add teacher");
        this.interfaceOptions.put(0, "back");
        this.newTeacher = new Teacher();
    }

    @Override
    public void execute(int input) {
        switch (input) {
            case 1: {
                System.out.println("Enter Teacher name");
                String name = inputRequest();
                if(isValidName(name)) {
                    newTeacher.setName(name);
                    interfaceOptions.replace(1, "Name: " + name);
                    isSet[0] = true;
                } else {
                    System.out.println("Invalid name");
                }
                break;
            }
            case 2: {
                System.out.println("Enter Teacher surname");
                String surname = inputRequest();
                if(isValidName(surname)) {
                    newTeacher.setSurname(surname);
                    interfaceOptions.replace(2, "Surname: " + surname);
                    isSet[1] = true;
                } else {
                    System.out.println("Invalid surname");
                }
                break;
            }
            case 3: {
                System.out.println("Enter Teacher age");
                String age = inputRequest();
                if(isCorrectAge(age)) {
                    newTeacher.setAge(Integer.parseInt(age));
                    interfaceOptions.replace(3, "Age: " + age);
                    isSet[2] = true;
                } else {
                    System.out.println("Invalid age");
                }
                break;
            }
            case 4: {
                System.out.println("Enter Teacher email");
                String email = inputRequest();
                if(isCorrectEmail(email)) {
                    newTeacher.setEmail(email);
                    interfaceOptions.replace(4, "Email: " + email);
                    isSet[3] = true;
                } else {
                    System.out.println("Invalid email");
                }
                break;
            }
            case 5: {
                System.out.println("Study Subject");
                String subject = inputRequest();
                if(isValidName(subject)) {
                    newTeacher.setStudySubject(subject);
                    interfaceOptions.replace(5, "Field of Study: " + subject);
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
                teacherService.addTeacher(newTeacher);
                System.out.println("Teacher has been added!");
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
