package conditionals;

public class IfStatementRunner {

    public static void main(String[] args) {

        int i = 26;
        // i is 25
        // i is 24
        // i is neither 25 or 24

        if (i == 25) {
            System.out.println("i=25");
        } else if (i == 24) {
            System.out.println("i=24");
        } else {
            System.out.println("i !=24 and i != 25");
        }

        puzzle1();
        puzzle2();
        puzzle3();
        puzzle5();
    }

    private static void puzzle1() {
        int k = 15;
        if (k > 20) {
            System.out.println(1);
        } else if (k > 10) {
            System.out.println(2);
        } else if (k < 20) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }
    }

    private static void puzzle2() {
        int l = 15;
        if (l < 20) {
            System.out.println("l<20");
        }
        if (l > 20) {
            System.out.println("l>20");
        } else {
            System.out.println("Who am I?");
        }
    }

    private static void puzzle3() {
        int m = 15;

        if (m > 20) {
            if (m < 20) {
                System.out.println("m>20");
            } else {
                System.out.println("Who am I?");
            }
        }
    }

    private static void puzzle5(){
        int number = 5;
        if (number<0) {
            number = number + 10;
        }
        number ++;
        System.out.println(number);
    }
}