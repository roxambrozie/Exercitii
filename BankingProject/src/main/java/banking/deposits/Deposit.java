package banking.deposits;

import banking.payment.Payment;
import banking.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deposit extends Product {

    String depositName;
    EnumDeposits.Deposits type;
    List<Payment> depositList = new ArrayList<>();
    boolean depositTerm;
    double interestRate;
    LocalDate startDate;
    private int depositId;
    private int id;


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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


    public EnumDeposits.Deposits getType() {
        return type;
    }

    public void setType(EnumDeposits.Deposits type) {
        this.type = type;
    }

    public List<Payment> getDepositList() {
        return depositList;
    }

    public void addDepositToList(Payment payment) {
        this.depositList.add(payment);
    }

    public boolean isDepositTerm() {
        return depositTerm;
    }

    public void setDepositTerm(boolean depositTerm) {
        this.depositTerm = depositTerm;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName() {
        Random rand = new Random();
        int index = rand.nextInt(10);
        if (type == EnumDeposits.Deposits.TERM_DEPOSIT) {
            this.depositName = "Term Deposit " + index;
        } else if (type == EnumDeposits.Deposits.NO_TERM_DEPOSIT) {
            this.depositName = "No Term Deposit " + index;
        } else this.depositName = "Common Deposit " + index;
    }

    public void setDepositTerm() {
        if (this.type.equals(EnumDeposits.Deposits.TERM_DEPOSIT)) {
            this.depositTerm = true;
        } else {
            this.depositTerm = false;
        }
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Deposit: \n");
        result.append("Balance: ").append(this.balance);
        result.append("\nDeposit type: ").append(this.type);
        result.append("\n\tDeposits made: [");
        for (Payment payment : this.depositList) {
            result.append("\n\t\t{paymentDate: ").append(payment.getPaymentDate()).append("\n\t\tpaymentAmount: ")
                    .append(payment.getPaymentAmount()).append("}");
        }
        result.append("]");
        return result.toString();
    }
}
