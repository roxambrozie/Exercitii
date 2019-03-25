package arrays;

import java.math.BigDecimal;

public class StudentRunner {
    public static void main(String[] args) {

        int i = 5;
        int j = i + 5;
        int k = i + 10;

        int[] marks = {99, 98, 100};

        Student student = new Student("Roxana", marks);

        Student student1 = new Student("Adam",97,98,100 );
        Student student2 = new Student("Eve",97,98 );


        int number = student.getNumberOfMarks();
        System.out.println("number of marks: " + number);

        int sum = student.getTotalSumOfMarks();
        System.out.println("sum of marks: " + sum);

        int maximumMark = student.getMaximumMark();
        System.out.println("maximum of marks: " + maximumMark);

        int minimumMark = student.getMinimumMark();
        System.out.println("minimum of marks: " + minimumMark);

        BigDecimal average = student.getAverageMarks();
        System.out.println("average marks: " + average);

        student.addNewMark(35);
        student.removeMarkAtIndex(1);

        System.out.println(student);
    }
}
