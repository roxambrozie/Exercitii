package exercitii;
import java.util.Scanner;

public class Exercise27 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        int integer = input.nextInt();

        if (integer<0){
            System.out.println("The number you introduced is negative.");
        }
        else if (integer>0) {
            System.out.println("The number you introduced is positive.");
        }
        else System.out.println("The number is 0.");
    }
}
