package banking.payment;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

public class Payment {
    public Payment() {
    }

    public LocalDate paymentDate;
    double paymentAmount;
    double totalPayment;
    int paymentId;
    int creditID;
    int depositId;
    int id;

    public Payment(int paymentId, int creditID, int depositId, int id, double paymentAmount, LocalDate paymentDate) {

        this.paymentId = paymentId;
        this.creditID = creditID;
        this.depositId = depositId;
        this.id = id;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;

    }

    public Payment(LocalDate paymentDate, double paymentAmount) {
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
    }

    public int getDepositId() {
        return depositId;
    }

    public void setDepositId(int depositId) {
        this.depositId = depositId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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