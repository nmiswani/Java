package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        startCalculator();
    }

    /**
     * Starts the calculator system with user interaction
     */
    public static void startCalculator() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Java Calculator System");
        System.out.println("--------------------------------");

        while (running) {
            displayMenu();

            System.out.print("Enter your choice (1-5): ");
            int choice = getIntInput(scanner, 1, 5);

            if (choice == 5) {
                running = false;
                System.out.println("Thank you for using the calculator. Goodbye!");
                continue;
            }

            System.out.print("Enter first number: ");
            double num1 = getDoubleInput(scanner);

            System.out.print("Enter second number: ");
            double num2 = getDoubleInput(scanner);

            try {
                double result = performOperation(choice, num1, num2);
                System.out.printf("Result: " + result + "\n");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }

        scanner.close();
    }

    /**
     * Displays the calculator menu options
     */
    private static void displayMenu() {
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
    }

    /**
     * Performs the selected arithmetic operation
     */
    private static double performOperation(int choice, double num1, double num2) {
        return switch (choice) {
            case 1 -> num1 + num2;
            case 2 -> num1 - num2;
            case 3 -> num1 * num2;
            case 4 -> {
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }

    /**
     * Gets valid integer input within a specified range
     */
    private static int getIntInput(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max) {
                    System.out.printf("Please enter a number between %d and %d: ", min, max);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    /**
     * Gets valid double input
     */
    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}