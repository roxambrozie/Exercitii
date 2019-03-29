package banking.credits;

import banking.myaccount.MyAccount;
import banking.payment.Payment;
import banking.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Credit extends Product {

    public EnumCredits.Credits type;
    public boolean mortgage = true;
    public int creditTerm;
    public double interestRate;
    public double monthlyInstallment;
    public double totalInstallment;
    public LocalDate startDate;
    public List<Payment> mortgagePaymentList = new ArrayList<>();
    public LocalDate referenceDate;
    public String creditName;
    double creditValue;
    public double sumPayments = 0.0;
    int id;
    private double penaltyInstallment;
    public int creditID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setMonthlyInstallment(double monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }

    public void setTotalInstallment(double totalInstallment) {
        this.totalInstallment = totalInstallment;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setMortgagePaymentList(List<Payment> mortgagePaymentList) {
        this.mortgagePaymentList = mortgagePaymentList;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public void setCreditValue(double creditValue) {
        this.creditValue = creditValue;
    }

    public void setSumPayments(double sumPayments) {
        this.sumPayments = sumPayments;
    }

    public double getMonthlyInstallment() {
        return monthlyInstallment;
    }

    public List<Payment> getMortgagePaymentList() {
        return mortgagePaymentList;
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    public double getSumPayments() {
        return sumPayments;
    }

    public String getCreditName() {
        return creditName;
    }

    public double getCreditValue() {
        return creditValue;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public boolean isMortgage() {
        return mortgage;
    }

    public void setMortgage(boolean mortgage) {
        this.mortgage = mortgage;
    }

    public void setName(String name) {
        this.creditName = name;
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

    public EnumCredits.Credits getType() {
        return type;
    }

    public void setReferenceDate(LocalDate referenceDate) {
        this.referenceDate = referenceDate;
    }

    public double getTotalInstallment() {
        return totalInstallment;
    }

    public void setTotalInstallment() {
        this.totalInstallment = this.creditTerm * monthlyInstallment;
    }

    public Credit(double creditValue, int duration, double dobanda, LocalDate startDate) {
        this.creditValue = creditValue;
        this.interestRate = dobanda;
        this.creditTerm = duration;
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


    public double getInstallmentAmountPerMonth() {

        if (this.creditTerm != 0) {
            this.monthlyInstallment = ((this.creditValue / this.creditTerm) * this.interestRate);
            return monthlyInstallment;
        } else {
            return 0;
        }
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

    public double getTotalAmountToBePaid() {
        for (Payment i : mortgagePaymentList) {
            sumPayments = sumPayments + i.getPaymentAmount();
        }
        return creditValue - sumPayments;
    }

    public double addPenaltyAfterUnpaidThreeMonths() {
        double penaltyInstallment = 0;
        if (!this.mortgagePaymentList.isEmpty() &&
                (this.mortgagePaymentList.get(this.mortgagePaymentList.size() - 1).paymentDate.isBefore(referenceDate))) {
            penaltyInstallment = 1.01 * (3 * monthlyInstallment);
        }
        return penaltyInstallment;
    }

    public int periodOfMonthsPaid() {
        int numberOfMonthsPaid =
                (int) (sumPayments / monthlyInstallment);
        return numberOfMonthsPaid;
    }

    public int periodOfMonthsLeftToBePaid() {
        int numberOfMonthsLeftToBePaid = (int) ((totalInstallment - sumPayments) / monthlyInstallment);
        return numberOfMonthsLeftToBePaid;
    }

    public Credit() {
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

}
