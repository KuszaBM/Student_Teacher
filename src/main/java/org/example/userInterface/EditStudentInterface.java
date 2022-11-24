package org.example.userInterface;

import org.example.model.Student;
import org.example.service.StudentService;

import java.util.Arrays;

public class EditStudentInterface extends UserInterface {
    public static final String NAME = "EntityManager";
    private final StudentService studentService;
    private Student student;

    public EditStudentInterface(StudentService studentService, int index) {
        super();
        this.studentService = studentService;
        this.interfaceOptions.put(1, "Name: " + student.getName());
        this.interfaceOptions.put(2, "Surname: "+ student.getSurname());
        this.interfaceOptions.put(3, "Age: "+ student.getAge());
        this.interfaceOptions.put(4, "Email: " + student.getEmail());
        this.interfaceOptions.put(5, "Field of Study: "+ student.getTeachers());
        this.interfaceOptions.put(7, "Add teacher");
        this.interfaceOptions.put(8, "Modify student");
        this.interfaceOptions.put(0, "back");
        this.student = student;
    }

    @Override
    public void execute(int input) {
        switch (input) {
            case 1: {
                System.out.println("Enter Student name");
                String name = inputRequest();
                if(isValidName(name)) {
                    student.setName(name);
                    interfaceOptions.replace(1, "Name: " + name);
                } else {
                    System.out.println("Invalid name");
                }
                break;
            }
            case 2: {
                System.out.println("Enter Student surname");
                String surname = inputRequest();
                if(isValidName(surname)) {
                    student.setSurname(surname);
                    interfaceOptions.replace(2, "Surname: " + surname);
                } else {
                    System.out.println("Invalid surname");
                }
                break;
            }
            case 3: {
                System.out.println("Enter Student age");
                String age = inputRequest();
                if(isCorrectAge(age)) {
                    student.setAge(Integer.parseInt(age));
                    interfaceOptions.replace(3, "Age: " + age);
                } else {
                    System.out.println("Invalid age");
                }
                break;
            }
            case 4: {
                System.out.println("Enter Student email");
                String email = inputRequest();
                if(isCorrectEmail(email)) {
                    student.setEmail(email);
                    interfaceOptions.replace(4, "Email: " + email);
                } else {
                    System.out.println("Invalid email");
                }
                break;
            }
            case 5: {
                System.out.println("Enter Field of Study");
                String field = inputRequest();
                if(isValidName(field)) {
                    student.setFieldOfStudy(field);
                    interfaceOptions.replace(5, "Field of Study: " + field);
                } else {
                    System.out.println("Invalid surname");
                }
                break;
            }
            case 6: {
                studentService.addStudent(student);
                student = new Student();
                System.out.println("Student has been edited!");
            }
            case 7: {
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
