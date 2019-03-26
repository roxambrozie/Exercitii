package exercitii;

public class Exercise10 {
    public static void main(String[] args) {
        int max = 10;

        System.out.println("The first 10 natural numbers are: ");
        for (int i = 1; i <= max; i++)
            System.out.println(i);

        System.out.println("The first 10 uneven numbers are: ");
        for (int i = 1; i <= max; i++)
            System.out.println(i++);

        System.out.println("The first 10 even numbers are: ");
        for (int i = 2; i <= max; i++)
            System.out.println(i++);
    }
}
