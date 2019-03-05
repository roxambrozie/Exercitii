package exercitii;
import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = in.nextInt();
        double sum = 0.0;

        System.out.println("First " + n + " natural numbers are:");
        for (int i=1; i <=n; i++){
            System.out.println(i);
            sum +=i;
        }

        System.out.println("Their sum is : " + sum );
    }

}
