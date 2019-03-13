package banking.myaccount;

import banking.credits.Credit;
import banking.deposits.Deposit;
import banking.users.User;

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

    public void addDepositToList (Deposit deposit) {
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

}
