package com.skbankapp;

/*
* Create an FDAccount class as a subclass of Account with the following additional properties:
* maturityDate of type LocalDate
* interestRate as a double
* Implement the following methods:

* getTenure: Returns the tenure in months.
* getMaturityAmount: Returns the maturity amount.
 */

import java.time.LocalDate;

public class FDAccount extends Account {
    private LocalDate maturityDate;
    private double interestRate;

    public FDAccount(int accountNumber, double balance, LocalDate openingDate, LocalDate maturityDate, double interestRate) {
        super(accountNumber, balance, openingDate);
        this.maturityDate = maturityDate;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        setBalance(getBalance() - amount);
        Transaction transaction = new Transaction.TransactionBuilder(LocalDate.now(), TransactionType.DEBIT, amount).build();
        getTransactionList().add(transaction);
    }

    public int getTenure() {
        return getOpeningDate().until(getMaturityDate()).getMonths();
    }

    public double getMaturityAmount() {
        return getBalance() + (getBalance() * getInterestRate() * getTenure() / 100);
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "FDAccount [interestRate=" + interestRate + ", maturityDate=" + maturityDate + ", toString()="
                + super.toString() + "]";
    }

}