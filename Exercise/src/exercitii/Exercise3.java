package exercitii;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please add three numbers:");

        int number1 = in.nextInt();
        int number2 = in.nextInt();
        int number3 = in.nextInt();

        if (number1 > number2) {
            if (number1 > number3) {
                System.out.println(number1 + " is the greatest number");
            }
        } else if (number2 > number3) {
            System.out.println(number2 + " is the greatest number");
        } else System.out.println(number3 + " is the greatest number");
    }
}
