package banking.myaccount;

import banking.credits.Credit;
import banking.deposits.Deposit;


import java.util.ArrayList;
import java.util.List;

public class MyAccount {

    List<Credit> creditList = new ArrayList<>();
    List<Deposit> depositList = new ArrayList<>();

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
