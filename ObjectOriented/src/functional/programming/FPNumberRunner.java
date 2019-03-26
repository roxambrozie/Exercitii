package functional.programming;

import java.util.Arrays;
import java.util.List;

public class FPNumberRunner {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(new Integer[]{4, 6, 8, 13, 3, 15});

        showAllElementsFunctionalProgramming(numbers);
        fpSum(numbers);
        int sum = getSumForOddNumberFunctionalProgramming(numbers);
        System.out.println(sum);

        normalSum(numbers);
    }

    private static void showAllElementsFunctionalProgramming(List<Integer> numbers) {
        numbers.stream()
                .forEach(element -> System.out.println(element));
    }

    private static int getSumForOddNumberFunctionalProgramming(List<Integer> numbers) {
        //Calculeaza suma pentru numerele impare
        return numbers.stream().filter(number -> number % 2 == 1)
                .reduce(0, (number1, number2)
                        -> number1 + number2);
    }

    private static int fpSum(List<Integer> numbers) {
        //Calculeaza suma pentru toate numerele din lista
        return numbers.stream().reduce(0,
                (number1, number2) -> {
                    System.out.println(number1 + " " + number2);
                    return number1 + number2;
        });
    }

    private static void normalSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
