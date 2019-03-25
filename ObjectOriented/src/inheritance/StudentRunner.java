package inheritance;

public class StudentRunner {

    public static void main(String[] args) {
//        Student student = new Student();
//        student.setName("Roxana");
//        student.setEmail("roxana@etc.com");
//
//        Person person = new Person();
//        person.setEmail("rox@a.com ");
//        person.setName("Roxana ");
//        person.setPhoneNumber("010101");
//
//        String value = person.toString();
//        System.out.println(value);
//        System.out.println(person);

        Emploeey emploeey = new Emploeey("Roxana", "QA");
        emploeey.setTitle("QA ");
        emploeey.setEmail("email");
        emploeey.setPhoneNumber("11");
        emploeey.setEmployeeGrade(10);
        emploeey.setEmployer("employer");

        System.out.println(emploeey);

    }
}
