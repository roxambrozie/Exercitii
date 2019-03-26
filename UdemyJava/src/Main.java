public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Planet earth = new Planet();
        earth.revolve();

        MultiplicationTable table = new MultiplicationTable();
        table.print();
        table.print(3);
        table.print(1,2,3);
    }
}
