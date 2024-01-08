package com.skbankapp;

/*
* Create an SBAccount class as a subclass of Account with the following additional properties:
* minBalance (double)
* Implement the following method:
* withdraw: Throws an InsufficientBalanceException if the amount is not available and adds a debit transaction to the transaction list for each withdrawal.
 */

import java.time.LocalDate;

public class SBAccount extends Account {
    private double minBalance;

    public SBAccount(int accountNumber, double balance, LocalDate openingDate, double minBalance) {
        super(accountNumber, balance, openingDate);
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance() || getBalance() - amount < getMinBalance()) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        setBalance(getBalance() - amount);
        Transaction transaction = new Transaction.TransactionBuilder(LocalDate.now(), TransactionType.DEBIT, amount).build();
        getTransactionList().add(transaction);
    }

    public double getMinBalance() {
        return minBalance;
    }


    @Override
    public String toString() {
        return "SBAccount [minBalance=" + minBalance + ", toString()=" + super.toString() + "]";
    }

}
