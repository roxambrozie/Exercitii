package exercitii;
import java.util.Scanner;

public class Exercise12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter five numbers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();
        int n4 = input.nextInt();
        int n5 = input.nextInt();
        int sum = n1+n2+n3+n4+n5;
        double average = sum/5;

        System.out.println("The sum of the numbers is : " + sum);
        System.out.println("The average of the numbers is : " + average);

    }
}
