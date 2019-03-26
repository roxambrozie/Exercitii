package collections;

import java.util.*;
import java.util.List;

public class SetRunner {
    public static void main(String[] args) {
        List<Character> characters = Arrays.asList(new Character[]{'A', 'Z', 'A', 'B', 'Z', 'F'});
        //unique - Set
        //Tree - everything is sorted
        //Hash
        //LinkedHash

        Set<Character> treeSet = new TreeSet<>(characters);
        System.out.println("TreeSet: "+ treeSet);

        Set<Character> linkedHashSet = new LinkedHashSet<>(characters);
        System.out.println("LinkedHashSet " + linkedHashSet);

        Set<Character> hashSet = new HashSet<>(characters);
        System.out.println("HashSet " + hashSet);
    }
}
