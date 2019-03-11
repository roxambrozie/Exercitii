package banking.myaccount;

import banking.Payment;
import banking.credits.Credit;
import banking.credits.EnumCredits;
import banking.deposits.Deposit;
import banking.deposits.EnumDeposits;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        MyAccount account = new MyAccount();
        Credit firstCredit = new Credit(10000, 12, 1.03, LocalDate.of(2018, 10, 01));
        account.addCreditTolist(firstCredit);

        System.out.println("Amount to be paid per month for the first credit: " + firstCredit.getInstallmentAmountPerMonth());
        firstCredit.setType(EnumCredits.Credits.MORTGAGE_CREDIT);
        firstCredit.setName();
        firstCredit.setMortgage();
        firstCredit.setTotalInstallment();
        System.out.println("The total installment for the first credit is: " + firstCredit.getTotalInstallment());
        Payment payment1 = new Payment(LocalDate.of(2018, 10, 1), 858.3333333333334);
        firstCredit.addPaymentsToList(payment1);
        Payment payment2 = new Payment(LocalDate.of(2018, 11, 1), 858.3333333333334);
        firstCredit.addPaymentsToList(payment2);
        System.out.println("\nThe first credit:  \n" + firstCredit);
        Credit.setReferenceDate(LocalDate.of(2018, 12, 1));
        System.out.println("\nFirst credit: the total amount to be paid with penalty is: " + firstCredit.addPenaltyAfterUnpaidThreeMonths());
        System.out.println("The payment installment for Credit " + account.creditList.get(0).getCreditName() + " is " + account.completeInstallmentForCreditWithName(account.creditList.get(0).getCreditName()));
        System.out.println("The amount left to be paid for the first credit is: " + firstCredit.getTotalMortgageToBePaid());

        Credit secondCredit = new Credit(1000, 12, 1.03, LocalDate.of(2018, 10, 01));
        account.addCreditTolist(secondCredit);
        System.out.println("\n\n\nAmount to be paid per month for the second credit: " + secondCredit.getInstallmentAmountPerMonth());
        secondCredit.setType(EnumCredits.Credits.REPAIRS_CREDIT);
        secondCredit.setName();
        secondCredit.setMortgage();
        secondCredit.setTotalInstallment();
        System.out.println("The total installment for the second credit is: " + secondCredit.getTotalInstallment());
        Payment paymentRepairs1 = new Payment(LocalDate.of(2018, 10, 1), 85.83333333333333);
        secondCredit.addPaymentsToList(paymentRepairs1);
        Payment paymentRepairs2 = new Payment(LocalDate.of(2018, 11, 1), 85.83333333333333);
        secondCredit.addPaymentsToList(paymentRepairs2);
        Payment paymentRepairs3 = new Payment(LocalDate.of(2018, 12, 1), 85.83333333333333);
        secondCredit.addPaymentsToList(paymentRepairs3);
        System.out.println("\nThe second credit:  \n" + secondCredit);
        Credit.setReferenceDate(LocalDate.of(2018, 12, 1));
        System.out.println("\nSecond credit: the total amount to be paid with penalty is: " + secondCredit.addPenaltyAfterUnpaidThreeMonths());
        System.out.println("The monthly payment installment for " + account.creditList.get(1).getCreditName() + " is " + account.completeInstallmentForCreditWithName(account.creditList.get(1).getCreditName()));
        System.out.println("The amount left to be paid for the second credit is: " + secondCredit.getTotalMortgageToBePaid());
        System.out.println("Period of months that had been paid for the second credit is: " + secondCredit.periodOfMonthsPaid());
        System.out.println("The number of months left to be paid for the second credit is: " + secondCredit.periodOfMonthsLeftToBePaid());

        Deposit firstDeposit = new Deposit();
        firstDeposit.setType(EnumDeposits.Deposits.NO_TERM_DEPOSIT);
        firstDeposit.setDepositName();
        firstDeposit.setBalance(1000);
        Payment depositPayment1 = new Payment(LocalDate.of(2019, 01,01), 100);
        firstDeposit.addDepositToList(depositPayment1);
        System.out.println("\nThe first deposit: \n" + firstDeposit);
    }
}
