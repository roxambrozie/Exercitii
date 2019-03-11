package banking;

import banking.credits.Credit;

import java.time.LocalDate;

public class Payment {
    public Payment() {
    }

    public LocalDate paymentDate;
    double paymentAmount;
    double totalPayment;

    public Payment(LocalDate paymentDate, double paymentAmount) {
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

}
