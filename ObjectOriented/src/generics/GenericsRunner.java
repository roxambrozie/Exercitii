package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRunner {


        static <X> X doubleValue(X value) {
            return value;
        }

        static <X extends List> void duplicate(X list) {
            list.addAll(list);
        }

        static double sumOfNumberList(List<? extends Number> numbers) {
            double sum = 0.0;
            for(Number number:numbers){
                sum += number.doubleValue();
            }
            return sum;

        }


    static void addACoupleOfValues(List<? super Number> numbers) {
        numbers.add(1);
        numbers.add(1.0);
        numbers.add(1.0f);
        numbers.add(1l);
    }

    public static void main(String[] args) {

        List emptyList = new ArrayList<Number>();
        addACoupleOfValues(emptyList);
        System.out.println(emptyList);

        MyCustomList<Long> list = new MyCustomList<>();
        list.addElement(5l);
        list.addElement(7l);
        Long value = list.get(0);
        System.out.println(value);

        MyCustomList<Integer> list2 = new MyCustomList<>();
        list2.addElement(Integer.valueOf(5));
        list2.addElement(Integer.valueOf(7));
        Integer number = list2.get(0);
        System.out.println(number);

    }

}
