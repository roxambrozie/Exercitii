package conditionals;

import java.util.Scanner;

public class MenuRunner {
    public static void main(String[] args) {

        //Type obj = new Type (argument);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number1: ");
        int number1 = scanner.nextInt();
        System.out.println("The number you entered is  " + number1);
        System.out.println("Enter Number2: ");
        int number2 = scanner.nextInt();

        System.out.println("Choices available are:");
        System.out.println("1 - Add");
        System.out.println("2 - Subtract");
        System.out.println("3 - Divide");
        System.out.println("4 - Multiply");

        System.out.println("Enter choice: ");
        int choice = scanner.nextInt();

        System.out.println("Your choices are");
        System.out.println("Number1 " + number1);
        System.out.println("Number2 " + number2);
        System.out.println("Choice " + choice);

       // performOperationUsingNestedIfElse(number1, number2, choice);
        performOperationUsingSwitch(number1, number2, choice);
    }

    private static void performOperationUsingNestedIfElse(int number1, int number2, int choice) {
        if (choice == 1) {
            System.out.println("Result " + (number1 + number2));
        } else if (choice == 2) {
            System.out.println("Result " + (number1 - number2));
        } else if (choice == 3) {
            System.out.println("Result " + (number1 / number2));
        } else if (choice == 4) {
            System.out.println("Result " + (number1 * number2));
        } else {
            System.out.println("Invalid operation.");
        }
    }

    private static void performOperationUsingSwitch(int number1, int number2, int choice) {
        switch (choice) {
            case 1:
                System.out.println("Result " + (number1 + number2));
                break;
            case 2:
                System.out.println("Result " + (number1 - number2));
                break;
            case 3:
                System.out.println("Result " + (number1 / number2));
                break;
            case 4:
                System.out.println("Result " + (number1 * number2));
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }
}
