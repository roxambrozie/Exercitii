package lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaBehindTheScreenRunner {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(new Integer[]{23,43,34,45,36,48});

        numbers.stream().filter(n-> n%2 ==0)
                .forEach(e-> System.out.println(e));

        //
    }
}
