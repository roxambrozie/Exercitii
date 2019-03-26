package exercitii;
import java.util.Scanner;

public class Exercise24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of rows: ");
        int i, j, space;
        int rows = input.nextInt();

        System.out.println("Result : ");
        for (i = 0; i < rows; i++) {
            for (space = rows -i; space>0;  space--){
                System.out.print(" ");
            }

            for (j = 0; j <= i; j++) {
                System.out.print("@");
            }
            System.out.println();
        }
    }
}
