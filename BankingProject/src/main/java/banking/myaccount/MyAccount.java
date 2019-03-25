package banking.myaccount;

import banking.credits.Credit;
import banking.credits.EnumCredits;
import banking.deposits.Deposit;
import banking.deposits.EnumDeposits;
import banking.users.User;
import banking.util.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static banking.database.DatabaseManager.*;

public class MyAccount {

    private User user;
    public List<Credit> creditList;
    public List<Deposit> depositList;

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

    public void getCreditNameAndMonthlyInstallment() {
        creditList.forEach(credit -> {
            System.out.println("The monthly installment for the credit with id: " + credit.getCreditName() + " is: " + credit.getInstallmentAmountPerMonth());
        });
    }

    public void getCreditAmountLeftToBePaid() {
        creditList.forEach(credit -> {
            System.out.println("The amount left to be paid is: " + credit.getTotalMortgageToBePaid());
        });
    }

    public void addDepositsToUser(Deposit deposit) {
        insertDeposits(deposit);
    }

    public void addCreditsToUser(Credit credit) {
        insertCredits(credit);
    }

    public void checkThatUserExistsInDatabase(int ssn) {
        checkUserExistsInDatabase(ssn);
    }

    public void returnThatUserDetails(int ssn) {
        returnUserDetails(ssn);
    }

    public void askUserForTheNextOperation(int ssn) {
        Scanner scanner = new Scanner(System.in);
        if (checkUserExistsInDatabase(ssn)) {
            Credit credit = new Credit();
            Deposit deposit = new Deposit();
            System.out.println(Constants.WISH_NEXT);
            int userWish = scanner.nextInt();

            switch (userWish) {
                case 1:
                    setCredits();
                    break;
                case 2:
                    setDeposits();
                    break;
                case 3:
                    setCredits();
                    getCreditNameAndMonthlyInstallment();
                    break;
                case 4:
                    getCreditAmountLeftToBePaid();
                    break;
                case 5:
                    credit.periodOfMonthsLeftToBePaid();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } else {
            System.out.println(Constants.INVALID_SSN);
        }
    }

    public void setUser(ResultSet rs) {
        try {
            rs.first();
            rs.previous();
            while (rs.next()) {
                User user1 = new User();
                user1.setId(rs.getInt(1));
                user1.setFirstName(rs.getString(2));
                user1.setLastName(rs.getString(3));
                user1.setDateOfBirth(rs.getDate(4).toLocalDate());
                user1.setSsn(rs.getInt(5));
                user1.setPhone(rs.getString(6));
                this.user = user1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCredits() {
        ResultSet rs = setCreditObjects(this.user.getSsn());

        try {
            rs.first();
            rs.previous();
            while (rs.next()) {
                Credit credit1 = new Credit();
                credit1.setName(rs.getString(1));
                credit1.setType(EnumCredits.Credits.getStringToEnum(rs.getString(2)));
                credit1.setInterestRate(rs.getInt(3));
                credit1.setStartDate(rs.getDate(4).toLocalDate());
                credit1.setCreditValue(rs.getDouble(5));
                credit1.setMortgage(rs.getBoolean(6));
                credit1.setId(rs.getInt(7));
                credit1.setCreditTerm(rs.getInt(8));
                this.addCreditTolist(credit1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDeposits() {
        ResultSet rs = setDepositObjects(this.user.getSsn());

        try {
            rs.first();
            rs.previous();
            while (rs.next()) {
                Deposit deposit1 = new Deposit();
                deposit1.setDepositId(rs.getInt(1));
                deposit1.setType(EnumDeposits.Deposits.getStringToEnum(rs.getString(2)));
                deposit1.setInterestRate(rs.getDouble(3));
                deposit1.setStartDate(rs.getDate(4).toLocalDate());
                deposit1.setDepositTerm(rs.getBoolean(5));
                deposit1.setId(rs.getInt(6));
                this.addDepositToList(deposit1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

