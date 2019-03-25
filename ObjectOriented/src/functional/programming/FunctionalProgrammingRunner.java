package functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalProgrammingRunner {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"Apple", "Bat", "Cat", "Dog"});

        printWithFunctionalProgrammingFiltering(list);
    }

    private static void printBasic(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }

    private static void printWithFunctionalProgramming(List<String> list) {
        list.stream().forEach(
                element -> System.out.println("Element - " + element)
        );
    }

    private static void printBasicWithFiltering(List<String> list) {
        for (String string : list) {
            if (string.endsWith("at")) {
                System.out.println(string);
            }
        }
    }

    private static void printWithFunctionalProgrammingFiltering(List<String> list) {
        list.stream()
                .filter(element -> element.endsWith("at"))
                .forEach(element -> System.out.println("Element - " + element)
                );
    }
}
