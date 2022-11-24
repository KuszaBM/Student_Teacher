package org.example.userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface CheckForInputInterface {
    public default boolean checkInput(String input, char[] availableCharacters) {
        boolean isCorrect = false;
        if (input == null || input.length() > 1) {
            return false;
        } else {
            char inputToChar = input.charAt(0);
            return true;
        }
    }
    public default String inputRequest() {
        String temp = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            temp = input;
        } catch(IOException e){
            System.out.println("No input.");
            temp = "no input";
            return temp;
        }
        return temp;
    }

    public boolean checkInput(String input);
}
