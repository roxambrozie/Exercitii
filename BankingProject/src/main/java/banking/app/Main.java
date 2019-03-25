package banking.app;

import banking.credits.Credit;
import banking.database.DatabaseManager;
import banking.myaccount.MyAccount;
import banking.users.User;
import banking.util.Constants;

import java.sql.ResultSet;
import java.util.Scanner;

import static banking.database.DatabaseManager.checkUserExistsInDatabase;
import static banking.database.DatabaseManager.returnUserDetails;

public class Main {
    public static void main(String[] args) {
        Credit credit = new Credit();
        MyAccount xAccount = new MyAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.ENTER_SSN);
        int ssn = scanner.nextInt();

        System.out.println(checkUserExistsInDatabase(ssn));
        ResultSet result = returnUserDetails(ssn);

        xAccount.setUser(result);
        xAccount.askUserForTheNextOperation(ssn);

    }
}
