package exercitii;

public class Exercise17to21 {
    private static int i, j;
    private static int rows = 4;

    public static void main(String[] args) {
        halfTriangleExercise17();
        halfTriangleExercise18();
        smallTriangleExercise19();
        floydsTriangleExercise20(4);
        diamondExercise21();

    }

    private static void halfTriangleExercise17() {
        System.out.println("Exercise17to21");
        for (i = 1; i <= 4; ++i) {
            for (j = 1; j <= i; ++j) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void halfTriangleExercise18() {
        System.out.println("\n\n Exercise18");
        int number = 1;

        for (i = 1; i <= rows; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(number + " ");
                ++number;
            }
            System.out.println();
        }
    }

    private static void smallTriangleExercise19() {
        System.out.println("\n\n Exercise19");
        int rowCount = 1;
        for (int i = rows; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= rowCount; j++) {
                System.out.print(rowCount + " ");
            }
            System.out.println();
            rowCount++;
        }
    }

    private static void floydsTriangleExercise20(int n) {
        System.out.println("\n\n Exercise20");
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                if (((i + j) % 2) == 0)
                    System.out.print("1");
                else
                    System.out.print("0");
            }
            System.out.println();
        }
    }

    private static void diamondExercise21() {
        System.out.println("\n\n Exercise21");
        int L = 6;
        if ((L % 2) != 0) {
            int add = 1;
            int numOfSpaces = L / 2;
            for (i = 1; i <= L; i++) {
                for (j = numOfSpaces; j >= 1; j--) {
                    System.out.print(" ");
                }
                for (j = 1; j <= add; j++) {
                    System.out.print("*");
                }
                System.out.println();
                if (i < (L / 2 + 1)) {
                    add = add + 2;
                    numOfSpaces = numOfSpaces - 1;
                } else {
                    add = add - 2;
                    numOfSpaces = numOfSpaces + 1;
                }
            }
        } else {

            int numOfSpaces = L / 2;
            int add = 1;

            for (i = 1; i <= L; i++) {
                for (j = numOfSpaces; j >= 1; j--) {
                    System.out.print(" ");
                }
                for (j = 1; j <= add; j++) {
                    System.out.print("*");
                }
                System.out.println();
                if (i < (L / 2 + 1)) {
                    add = add + 2;
                    numOfSpaces = numOfSpaces - 1;
                } else {
                    add = add - 2;
                    numOfSpaces = numOfSpaces + 1;
                }
            }
        }
    }
}
