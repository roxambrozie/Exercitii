import banking.credits.Credit;
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
        assertEquals(monthlyInstallment, credit.getInstallmentAmountPerMonth(), 1e-8);
    }

    @Test
    public void getMortgageToBePaid() {
        Credit credit = new Credit();
        Payment payment1 = new Payment(LocalDate.of(2018, 11, 1), 100);
        Payment payment2 = new Payment(LocalDate.of(2018, 11, 1), 100);
        credit.addPaymentsToList(payment1);
        credit.addPaymentsToList(payment2);
        double totalInstallment = 1.000;
        double mortgageLeftToBePaid = totalInstallment - 400;
        for (Payment i :
                credit.mortgagePaymentList) {
            credit.sumPayments = credit.sumPayments + i.getPaymentAmount();
        }
        credit.setTotalInstallment(totalInstallment);
        assertEquals(mortgageLeftToBePaid, credit.getTotalMortgageToBePaid(), 1e-8);

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
        assertEquals(penaltyInstallmentTest, credit.addPenaltyAfterUnpaidThreeMonths(), 1e-8);
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
        assertEquals(numberOfMonthsPaidTest, credit.periodOfMonthsPaid(), 1e-8);
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
        assertEquals(numberOfMonthsToBePaidTest, credit.periodOfMonthsLeftToBePaid(), 1e-8);
    }

    @Test
    public void addCreditToList() {
        Credit creditTest = new Credit(10000, 12, 1.03, LocalDate.of(2018, 10, 1));
        List<Credit> creditListTest = Arrays.asList(creditTest);
        assertThat(creditListTest, contains(creditTest));
    }

    @Test
    public void checkCreditListIsEmpty() {
        List<Credit> emptyCreditListTest=new ArrayList<>();
        assertThat(emptyCreditListTest, IsEmptyCollection.empty());
    }

    @Test
    public void checkCreditListSizeAndOrder() {
        Credit creditTest1 = new Credit(10000, 12, 1.03, LocalDate.of(2018, 10, 1));
        Credit creditTest2 = new Credit(10000, 12, 1.03, LocalDate.of(2018, 11, 1));
        Credit creditTest3 = new Credit(10000, 12, 1.03, LocalDate.of(2018, 12, 1));
        List<Credit> creditListTest = Arrays.asList(creditTest1,creditTest2,creditTest3);
        assertThat(creditListTest.size(), is(3));
        assertThat(creditListTest, contains(creditTest1,creditTest2,creditTest3));
    }
}
