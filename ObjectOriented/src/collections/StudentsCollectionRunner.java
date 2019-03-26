package collections;

import java.util.*;


class AscendingStudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getId(), student2.getId());
    }
}

public class StudentsCollectionRunner {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("Roxana", 1),
                new Student("Adam", 100),
                new Student("Eve", 2));

        List<Student> studentsAl = new ArrayList<>(students);

        System.out.println(studentsAl);

        Collections.sort(studentsAl, new AscendingStudentComparator());
        System.out.println("Ascending student compataor:" + studentsAl);

        studentsAl.sort(new AscendingStudentComparator());


    }
}
