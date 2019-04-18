package banking.app;

import banking.credits.Credit;
import banking.database.DatabaseManager;
import banking.myaccount.MyAccount;
import banking.payment.Payment;
import banking.users.User;
import banking.util.Constants;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import static banking.database.DatabaseManager.*;

public class Main {
    public static void main(String[] args) {
        Credit credit = new Credit();
        DatabaseManager manager = new DatabaseManager();
       MyAccount xAccount = new MyAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.ENTER_SSN);
        int ssn = scanner.nextInt();

        System.out.println(checkUserExistsInDatabase(ssn));
        ResultSet result = returnUserDetails(ssn);
        xAccount.setUser(result);

        xAccount.askUserForTheNextOperation(ssn);
//        Payment payment305 = new Payment(305, 102, 1,0,  100.0, LocalDate.of(2018, 11, 1));
//        xAccount.addPayments(payment305);


    }
}
