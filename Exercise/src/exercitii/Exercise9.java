package exercitii;
import java.util.Scanner;

import static exercitii.Exercise7.isLeapYear;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please add a year to be checked: ");
        int year = in.nextInt();

        System.out.println(isLeapYear(year));
    }
}
