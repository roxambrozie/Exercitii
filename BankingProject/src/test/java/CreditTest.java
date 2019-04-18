import banking.credits.Credit;
import banking.myaccount.MyAccount;
import banking.payment.Payment;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static banking.database.DatabaseManager.checkUserExistsInDatabase;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CreditTest {

    @Test
    public void userExistsInDatabasePositiveScenario() {
        int ssn = 111111111;
        assertTrue("User does not exist in the database. ", checkUserExistsInDatabase(ssn));
    }

    @Test
    public void userDoesNotExistInDatabase() {
        int ssn = 123456789;
        assertFalse("User exists in the database", checkUserExistsInDatabase(ssn));
    }

    @Test
    public void calculateMonthlyInstallment() {
        Credit credit = new Credit();
        double creditValue = 1000;
        int creditTerm = 10;
        double interestRate = 1.01;
        double monthlyInstallment;
        monthlyInstallment = (creditValue / creditTerm) * interestRate;
        credit.setCreditValue(creditValue);
        credit.setCreditTerm(10);
        credit.setInterestRate(1.01);
        assertEquals("The monthly was not correctly calculated.", monthlyInstallment, credit.getInstallmentAmountPerMonth(), 1e-8);
    }

    @Test
    public void getMortgageToBePaid() {
        Credit credit = new Credit();
        Payment payment1 = new Payment(LocalDate.of(2018, 11, 1), 100);
        Payment payment2 = new Payment(LocalDate.of(2018, 11, 1), 100);
        credit.addPaymentsToList(payment1);
        credit.addPaymentsToList(payment2);
        double totalInstallment = 1000;
        double mortgageLeftToBePaid = totalInstallment ;
        for (Payment i :
                credit.mortgagePaymentList) {
            credit.sumPayments = credit.sumPayments + i.getPaymentAmount();
        }
        credit.setTotalInstallment(totalInstallment);
        mortgageLeftToBePaid = totalInstallment - credit.sumPayments;
        assertEquals("The mortgage to be paid was not correctly calculated.", mortgageLeftToBePaid, credit.getTotalMortgageToBePaid(), 1e-8);

    }

    @Test
    public void penaltyAfterUnpaidThreeMonths() {
        Credit credit = new Credit();
        Payment payment1 = new Payment(LocalDate.of(2018, 11, 1), 858.3333333333334);
        Payment payment2 = new Payment(LocalDate.of(2018, 11, 1), 858.3333333333334);
        credit.addPaymentsToList(payment1);
        credit.addPaymentsToList(payment2);
        credit.setReferenceDate(LocalDate.of(2018, 12, 1));
        double penaltyInstallmentTest = 1.01 * (3 * credit.monthlyInstallment);
        assertEquals("The penalty to be paid was not correctly calculated.", penaltyInstallmentTest, credit.addPenaltyAfterUnpaidThreeMonths(), 1e-8);
    }

    @Test
    public void calculatePeriodOfMonthsPaid() {
        Credit credit = new Credit();
        Payment payment1 = new Payment(LocalDate.of(2018, 11, 1), 858.3333333333334);
        Payment payment2 = new Payment(LocalDate.of(2018, 11, 1), 858.3333333333334);
        credit.addPaymentsToList(payment1);
        credit.addPaymentsToList(payment2);
        for (Payment i :
                credit.mortgagePaymentList) {
            credit.sumPayments = credit.sumPayments + i.getPaymentAmount();
        }
        double monthlyInstallmentTest = credit.getInstallmentAmountPerMonth();
        int numberOfMonthsPaidTest = (int) (credit.sumPayments / monthlyInstallmentTest);
        assertEquals("The number of months that have been paid was not correctly calculated.", numberOfMonthsPaidTest, credit.periodOfMonthsPaid(), 1e-8);
    }

    @Test
    public void calculatePeriodOfMonthsLeftToBePaid() {
        Credit credit = new Credit();
        Payment payment1 = new Payment(LocalDate.of(2018, 11, 1), 100);
        Payment payment2 = new Payment(LocalDate.of(2018, 11, 1), 100);
        credit.addPaymentsToList(payment1);
        credit.addPaymentsToList(payment2);
        for (Payment i :
                credit.mortgagePaymentList) {
            credit.sumPayments = credit.sumPayments + i.getPaymentAmount();
        }
        double monthlyInstallmentTest = credit.getInstallmentAmountPerMonth();
        double totalInstallment = 1.000;

        int numberOfMonthsToBePaidTest = (int) ((totalInstallment - credit.sumPayments) / monthlyInstallmentTest);
        assertEquals("The number of months left to be paid was not correctly calculated.", numberOfMonthsToBePaidTest, credit.periodOfMonthsLeftToBePaid(), 1e-8);
    }

    @Test
    public void addCreditToList() {
        Credit creditTest = new Credit(10000, 12, 1.03, LocalDate.of(2018, 10, 1));
        List<Credit> creditListTest = Arrays.asList(creditTest);
        assertThat("The credit wad not added to the list.", creditListTest, contains(creditTest));
    }

    @Test
    public void checkCreditListIsEmpty() {
        List<Credit> emptyCreditListTest = new ArrayList<>();
        assertThat("The credit list is not empty.", emptyCreditListTest, IsEmptyCollection.empty());
    }

    @Test
    public void checkCreditListSizeAndOrder() {
        Credit creditTest1 = new Credit(10000, 12, 1.03, LocalDate.of(2018, 10, 1));
        Credit creditTest2 = new Credit(10000, 12, 1.03, LocalDate.of(2018, 11, 1));
        Credit creditTest3 = new Credit(10000, 12, 1.03, LocalDate.of(2018, 12, 1));
        List<Credit> creditListTest = Arrays.asList(creditTest1, creditTest2, creditTest3);
        assertThat("The list does  not contain the expected number of credits.", creditListTest.size(), is(3));
        assertThat("The list does not contain the credits in the same order they have been added.", creditListTest, contains(creditTest1, creditTest2, creditTest3));
    }

    @Test
    public void checkCorrectInstallmentComputation() {
        Credit creditTest = new Credit(10000, 12, 1.03, LocalDate.of(2018, 10, 1));
        double installment = creditTest.getInstallmentAmountPerMonth();
        assertEquals("There is different data regarding the credit", installment, creditTest.getInstallmentAmountPerMonth(), 1e-8);
    }

    //no payment but calculate how much is left to be paid
    //pay all credit, calculate to be 0
    //negative/positive: precision
    //penalty added to total installment if credit is not paid for 3 months and then paid for 1 month
    //negative : check to no be allowed to pay with negative numbers
    //neg for months

    @Test
    public void noPaymentsCalculateHowMuchIsLeftToBePaid() {
        Credit creditTest = new Credit(10000, 12, 1.03, LocalDate.of(2018, 10, 1));
        double totalInstallment = 1000;
        creditTest.setTotalInstallment(totalInstallment);
        double mortgageLeftToBePaid = totalInstallment ;
        mortgageLeftToBePaid = totalInstallment - creditTest.sumPayments;
        assertEquals("The mortgage to be paid was not correctly calculated.", totalInstallment, creditTest.getTotalMortgageToBePaid(), 1e-8);
    }

    @Test
    public void getNoMortgageLeftToBePaidWhenAllPaymentsAreDone() {
        Credit creditTest = new Credit();
        double totalInstallment = 300;
        Payment payment1 = new Payment(LocalDate.of(2018, 10, 1), 100);
        Payment payment2 = new Payment(LocalDate.of(2018, 11, 1), 100);
        Payment payment3 = new Payment(LocalDate.of(2018, 12, 1), 100);
        creditTest.addPaymentsToList(payment1);
        creditTest.addPaymentsToList(payment2);
        creditTest.addPaymentsToList(payment3);
        double mortgageLeftToBePaid = totalInstallment ;
        for (Payment i :
                creditTest.mortgagePaymentList) {
            creditTest.sumPayments = creditTest.sumPayments + i.getPaymentAmount();
        }
        creditTest.setTotalInstallment(totalInstallment);
        mortgageLeftToBePaid = totalInstallment - creditTest.sumPayments;
        assertEquals("The mortgage to be paid was not correctly calculated.", mortgageLeftToBePaid, creditTest.getTotalMortgageToBePaid(), 1e-8);
    }


}
