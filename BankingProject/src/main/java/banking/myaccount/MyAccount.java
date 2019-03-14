package banking.myaccount;

import banking.credits.Credit;
import banking.database.DatabaseManager;
import banking.deposits.Deposit;
import banking.users.User;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyAccount {

    User user;
    List<Credit> creditList;
    List<Deposit> depositList;

    public MyAccount() {
        this.user = new User();
        this.creditList = new ArrayList<>();
        this.depositList = new ArrayList<>();
    }

    public void addCreditTolist(Credit credit) {
        creditList.add(credit);
    }

    public void addDepositToList(Deposit deposit) {
        depositList.add(deposit);
    }

    public Double completeInstallmentForCreditWithName(String name) {
        double installment = 0.0;
        for (Credit credit : this.creditList) {
            if (credit.getCreditName().equals(name)) {
                installment = credit.getInstallmentAmountPerMonth();
            }
        }
        return installment;
    }

    public boolean checkUserExistsInDatabase(int ssn) {
        String query = "SELECT * FROM users WHERE ssn = " + ssn + ";";
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs != null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public ResultSet returnUserDetails(int ssn) {
        String query = "SELECT * FROM users WHERE ssn = " + ssn + ";";
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs != null) {
                while (rs.next())
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
                            + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
                rs.first();
            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void addDepositsToUser (Deposit deposit) {
        DatabaseManager database = new DatabaseManager();

    }

}

