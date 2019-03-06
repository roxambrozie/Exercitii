package exercitii;
import java.util.Scanner;

public class Exercise13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter four numbers : ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();
        int n4 = input.nextInt();
        int cube1 = n1*n1*n1;
        int cube2 = n2*n2*n2;
        int cube3 = n3*n3*n3;
        int cube4 = n4*n4*n4;

        System.out.println("Number is : " + n1 + " and cube of " + n1 + "is : " + cube1);
        System.out.println("Number is : " + n2 + " and cube of " + n2 + "is : " + cube2);
        System.out.println("Number is : " + n3 + " and cube of " + n3 + "is : " + cube3);
        System.out.println("Number is : " + n4 + " and cube of " + n4 + "is : " + cube4);
    }
}
