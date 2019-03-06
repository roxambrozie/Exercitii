package exercitii;
import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        int multiply0 = number * 0;
        int multiply1 = number * 1;
        int multiply2 = number * 2;
        int multiply3 = number * 3;
        int multiply4 = number * 4;
        int multiply5 = number * 5;

        System.out.println(number + " X 0 = " + multiply0 );
        System.out.println(number + " X 1 = " + multiply1 );
        System.out.println(number + " X 2 = " + multiply2 );
        System.out.println(number + " X 3 = " + multiply3 );
        System.out.println(number + " X 4 = " + multiply4 );
        System.out.println(number + " X 5 = " + multiply5 );
    }
}
