package collections;

import java.util.*;


class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String value1, String value2) {
        return Integer.compare(value1.length(), value2.length());
    }
}

public class QueueRunner {

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>(new StringLengthComparator());
        queue.addAll(Arrays.asList(new String[]{"Zebra", "Monkey", "Cat"}));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
