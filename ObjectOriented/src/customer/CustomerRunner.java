package customer;

public class CustomerRunner {

    public static void main(String[] args) {

        Address homeAddress = new Address("line1", "Hyderabad", "500035");
        Customer customer = new Customer("Roxana", homeAddress);

        Address workAddress = new Address("line 1 for work", "Hyderabad", "500035");
        customer.setWorkAddress(workAddress);

        System.out.println(customer);

    }
}
