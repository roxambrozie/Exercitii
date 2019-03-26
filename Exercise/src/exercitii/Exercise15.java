package exercitii;
import java.util.Scanner;

public class Exercise15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();

        System.out.println("The first uneven up to " + number + " are: ");
        for (int i = 1; i <= number; i++)
            System.out.println(i++);

        System.out.println("The sum of the first " + number + " odd numbers is: " + sum(number));
    }

    public static int sum(int number){
        int sum = 0;
        for (int i =1; i< number*2; i+=2){

            sum += i;
        }
        return sum;
    }
}
