package exercitii;

import java.util.*;

public class Exercise16 {
    public static void main(String[] args) {
        int i, j, rows;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        rows = input.nextInt();

        System.out.println("Result : ");
        for (i = 1; i <= rows; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
