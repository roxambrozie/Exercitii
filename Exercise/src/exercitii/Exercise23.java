package exercitii;

import java.util.Scanner;

public class Exercise23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i, j, space;
        System.out.println("Please enter the number of rows: ");
        int rows = input.nextInt();

        System.out.println("Result : ");
        for (i = rows; i > 0; i--) {
            for (space = rows -i; space>0;  space--){
                System.out.print(" ");
            }
            for (j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
