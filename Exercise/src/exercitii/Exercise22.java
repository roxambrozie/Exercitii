package exercitii;
import java.util.Scanner;

public class Exercise22 {
    public static void main(String[] args) {
        int rows,i,j,k;
        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter number of rows:");
        rows = input.nextInt();

        for(i=0; i<rows; i++) {
            for(k=rows; k>i; k--) {
                System.out.print(" ");
            }
            number =1;
            for(j=0; j<=i;j++){
                System.out.print(number + " ");
                number = number * (i-j)/(j+1);
            }
            System.out.println();
        }
    }
}
