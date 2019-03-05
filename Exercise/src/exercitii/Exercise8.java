package exercitii;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please add a character: ");

        String letter = in.nextLine();

        if (letter.equals("a") || letter.equals("A") || letter.equals("e") || letter.equals("E")
                || letter.equals("i") || letter.equals("I") || letter.equals("o") || letter.equals("O")
                || letter.equals("u") || letter.equals("U")) {
            System.out.println("This character is a vowel.");
        }
         else if (letter.equals("b") || letter.equals("B") || letter.equals("c") || letter.equals("C")
                || letter.equals("d") || letter.equals("D") || letter.equals("f") || letter.equals("F") || letter.equals("g") || letter.equals("G")
                || letter.equals("h") || letter.equals("H") || letter.equals("j") || letter.equals("J") || letter.equals("k") || letter.equals("K")
                || letter.equals("l") || letter.equals("L") || letter.equals("m") || letter.equals("M") || letter.equals("n") || letter.equals("N")
                || letter.equals("p") || letter.equals("P") || letter.equals("q") || letter.equals("Q") || letter.equals("r") || letter.equals("R")
                || letter.equals("s") || letter.equals("S") || letter.equals("t") || letter.equals("T") || letter.equals("v") || letter.equals("V")
                || letter.equals("w") || letter.equals("W") || letter.equals("x") || letter.equals("X") || letter.equals("y") || letter.equals("Y")
                || letter.equals("z") || letter.equals("Z") ){
            System.out.println("This character is a consonant.");
        }
        else if (letter.length() > 1) {
            System.out.println("This is a string!");
        }
        else {
            System.out.println("Error");
        }
    }
}
