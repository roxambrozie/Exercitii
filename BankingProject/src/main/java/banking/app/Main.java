package banking.app;

import banking.myaccount.MyAccount;
import banking.users.User;
import banking.util.Constants;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User firstUser = new User();
        MyAccount xAccount = new MyAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.ENTER_SSN);
        int ssn = scanner.nextInt();
        firstUser.setSsn(ssn);
        System.out.println(xAccount.checkUserExistsInDatabase(ssn));
        xAccount.returnUserDetails(ssn);



    }
}
