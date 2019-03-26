package arrays;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

class Student {

    private String name;
    private ArrayList<Integer> marks = new ArrayList<Integer>();

    Student(String name, int... marks) {
        this.name = name;

        for (int mark : marks) {
            this.marks.add(mark);
        }
    }

    int getNumberOfMarks() {
        return marks.size();
    }

    int getTotalSumOfMarks() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    int getMaximumMark() {
       return Collections.max(marks);
    }

    int getMinimumMark() {
       return Collections.min(marks);
    }

    BigDecimal getAverageMarks() {
        int sum = getTotalSumOfMarks();
        int number = getNumberOfMarks();

        return new BigDecimal(sum).divide(new BigDecimal(number), 3, RoundingMode.UP);
    }

    void addNewMark(int mark) {
        marks.add(mark);
    }

    void removeMarkAtIndex(int index) {
        marks.remove(index);

    }

    public String toString() {
        return name + marks;
    }
}
