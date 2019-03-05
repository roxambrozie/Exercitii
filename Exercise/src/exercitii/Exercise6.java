package exercitii;
import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please add two floating numbers: ");

        float a = in.nextFloat();
        float b = in.nextFloat();

        int retval = Float.compare(a, b);

        a = Math.round(a*1000);
        a = a/1000;

        b = Math.round(b*1000);
        b = b/1000;

        if(retval > 0) {
            System.out.println("a is greater than b");
        } else if(retval < 0) {
            System.out.println("a is less than b");
        } else {
            System.out.println("a is equal to b");
        }
    }
}
