package exercitii;

import java.util.Scanner;

public class Exercise25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of rows: ");
        int i, j;
        int rows = input.nextInt();

        if ((rows % 2) ==0) {
            int add = 1;
            int numOfSpaces = rows/2;
            for (i =1; i<=rows; i++ ) {
                for (j=numOfSpaces; j>=1; j--){
                    System.out.print(" ");
                }
                for (j =1; j <=add; j++){
                    System.out.print(i++);
                }
                System.out.println();
                if (i < (rows/2 +1)){
                    add = add +2;
                    numOfSpaces = numOfSpaces-1;
                } else{
                    add = add -2;
                    numOfSpaces = numOfSpaces+1;
                }
            }
        } else{
            int add =1;
            int numofSpaces=rows/2;
            for (j=numofSpaces; j>=1; j--){
                System.out.print(" ");
            }
            for (j=1; j<=add -2; j++){
                System.out.print(j++);
            }
            System.out.println();
        }
    }
}
