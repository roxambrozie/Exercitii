package exercitii;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise8a {
    private static Scanner in = new Scanner(System.in);
    private static String letter = in.nextLine();
    private static List<String> vowels = new ArrayList<>();
    private static List<String> consonants = new ArrayList<>();

    private static void addVowelsToList() {
        vowels.add("a");
        vowels.add("A");
        vowels.add("e");
        vowels.add("E");
        vowels.add("i");
        vowels.add("I");
        vowels.add("o");
        vowels.add("O");
        vowels.add("u");
        vowels.add("U");
    }

    private static void addConsonantsToList() {
        consonants.add("b");
        consonants.add("B");
        consonants.add("c");
        consonants.add("C");
        consonants.add("d");
        consonants.add("D");
        consonants.add("f");
        consonants.add("F");
        consonants.add("g");
        consonants.add("G");
        consonants.add("h");
        consonants.add("H");
        consonants.add("j");
        consonants.add("J");
        consonants.add("k");
        consonants.add("K");
        consonants.add("l");
        consonants.add("L");
        consonants.add("m");
        consonants.add("M");
        consonants.add("n");
        consonants.add("N");
        consonants.add("p");
        consonants.add("P");
        consonants.add("q");
        consonants.add("Q");
        consonants.add("r");
        consonants.add("R");
        consonants.add("s");
        consonants.add("S");
        consonants.add("t");
        consonants.add("T");
        consonants.add("v");
        consonants.add("V");
        consonants.add("w");
        consonants.add("W");
        consonants.add("x");
        consonants.add("X");
        consonants.add("y");
        consonants.add("Y");
        consonants.add("z");
        consonants.add("Z");
    }


    private static void checkInput(String letter) {

        if (vowels.contains(letter)) {
            System.out.println("The character is a vowel!");
        } else if (consonants.contains(letter)) {
            System.out.println("The character is a consonant!");
        } else if (letter.length() > 1) {
            System.out.println("This is a string!");
        } else {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {

        addVowelsToList();
        addConsonantsToList();
        checkInput(letter);
    }
}
