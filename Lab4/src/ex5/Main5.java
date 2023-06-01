package ex5;

import ex4.ArrayStack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main5 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/ex5/postfixData.txt"))) {
            String input;

            while ((input = br.readLine()) != null) {
                String[] inputArray = input.split(" ");
                System.out.println(input);
                System.out.println(calculate(inputArray));
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int calculate(String[] inputArray) {
        ArrayStack<Integer> stack = new ArrayStack<>(inputArray.length);
        int firstNumber;
        int secondNumber;

        for (String s : inputArray)
            if (s.equals("+") || s.equals("*")) {
                firstNumber = stack.pop();
                secondNumber = stack.pop();

                switch (s) {
                    case "+" -> stack.push(firstNumber + secondNumber);
                    case "*" -> stack.push(firstNumber * secondNumber);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }

        return stack.pop();
    }
}
