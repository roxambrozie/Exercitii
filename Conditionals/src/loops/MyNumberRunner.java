package loops;

public class MyNumberRunner {
    public static void main(String[] args) {
        MyNumber number = new MyNumber(3);
        boolean isPrime = number.isPrime();
        System.out.println("isPrime " + isPrime);

        int sum = number.sumUpToN();
        System.out.println("sumUpToN " + sum);

        int sumOfDivisor = number.sumOfDivisors();
        System.out.println("sumOfDivisors " + sumOfDivisor);

        number.printNumberTriangle();
    }
}
