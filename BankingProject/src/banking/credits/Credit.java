package banking.credits;

import banking.payment.Payment;
import banking.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Credit extends Product {
    EnumCredits.Credits type;
    boolean mortgage;
    int duration;
    double creditValue;
    double dobanda;
    static double monthlyInstallment;
    double totalInstallment;
    LocalDate startDate;
    List<Payment> mortgagePaymentList = new ArrayList<>();
    static LocalDate referenceDate;
    String creditName;
    double sumPayments = 0.0;

    public String getCreditName() {
        return creditName;
    }

    public void setName() {

        Random rand = new Random();
        int index = rand.nextInt(10);
        if (type == EnumCredits.Credits.MORTGAGE_CREDIT) {
            this.creditName = "Mortgage " + index;
        } else if (type == EnumCredits.Credits.REPAIRS_CREDIT) {
            this.creditName = "Repairs Credit " + index;
        } else this.creditName = "Personal Needs Credit " + index;
    }

    public static void setReferenceDate(LocalDate referenceDate) {
        Credit.referenceDate = referenceDate;
    }

    public double getTotalInstallment() {
        return totalInstallment;
    }

    public void setTotalInstallment() {
        this.totalInstallment = this.duration * monthlyInstallment;
    }

    public Credit(double creditValue, int duration, double dobanda, LocalDate startDate) {
        this.creditValue = creditValue;
        this.dobanda = dobanda;
        this.duration = duration;
        this.startDate = startDate;
    }

    public void setMortgage() {
        if (this.type.equals(EnumCredits.Credits.MORTGAGE_CREDIT)) {
            this.mortgage = true;
        } else {
            this.mortgage = false;
        }
    }

    public void setType(EnumCredits.Credits type) {
        this.type = type;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Credit: \n");
        result.append("Balance: ").append(this.balance);
        result.append("\nMortgage: ").append(this.mortgage);
        result.append("\nCredit type: ").append(this.type);
        result.append("\n\tPayments: [");
        for (Payment payment : this.mortgagePaymentList) {
            result.append("\n\t\t{paymentDate: ").append(payment.getPaymentDate()).append("\n\t\tpaymentAmount: ")
                    .append(payment.getPaymentAmount()).append("}");
        }
        result.append("]");
        return result.toString();
    }

    public double getInstallmentAmountPerMonth() {
        this.monthlyInstallment = ((this.creditValue / this.duration) * this.dobanda);
        return monthlyInstallment;
    }

    public void addPaymentsToList(Payment payment) {
        this.mortgagePaymentList.add(payment);
    }

    public double getTotalMortgageToBePaid() {
        for (Payment i : mortgagePaymentList) {
            sumPayments = sumPayments + i.getPaymentAmount();
        }
        return totalInstallment - sumPayments;
    }

    public double addPenaltyAfterUnpaidThreeMonths() {
        double penaltyInstallment = 0;
        if (!this.mortgagePaymentList.isEmpty() &&
                (this.mortgagePaymentList.get(this.mortgagePaymentList.size() - 1).paymentDate.isBefore(this.referenceDate))) {
            penaltyInstallment = 1.01 * (3 * this.monthlyInstallment);
        }
        return penaltyInstallment;
    }

    public int periodOfMonthsPaid () {
        int numberOfMonthsPaid =
                (int) (sumPayments/monthlyInstallment);
        return  numberOfMonthsPaid;
    }

    public int periodOfMonthsLeftToBePaid() {
         int numberOfMonthsLeftToBePaid =
                 (int) ((totalInstallment - sumPayments) / monthlyInstallment);
         return numberOfMonthsLeftToBePaid;
    }


}
