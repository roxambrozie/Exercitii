package exercitii;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please add a number: ");

        int m = in.nextInt();
        int n;

        if (m>0) {
            n=1;
        }
        else if (m==0) {
            n=0;
        }
        else n=-1;

        System.out.println("Value of n is: " + n);
    }
}
