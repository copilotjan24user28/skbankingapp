package com.skbankapp;

/*
 * Create an abstract class named Account with the following properties:

 *   accountNumber (int)
 *   transactionList, a list of Transaction objects
 *   balance (double)
 *   openingDate (LocalDate)
 *   Define the following methods:
 *   deposit: Adds a credit transaction to the transaction list for each deposit.
 *   getAccountDetails: Returns a string with the account details.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private int accountNumber;
    private List<Transaction> transactionList;
    private double balance;
    private LocalDate openingDate;

    public Account(int accountNumber, double balance, LocalDate openingDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.transactionList = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        Transaction transaction = new Transaction.TransactionBuilder(LocalDate.now(), TransactionType.CREDIT, amount).build();
        this.transactionList.add(transaction);
        this.balance += amount;
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    public String getAccountDetails() {
        return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", openingDate=" + openingDate
                + ", transactionList=" + transactionList + "]";
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", openingDate=" + openingDate
                + ", transactionList=" + transactionList + "]";
    }

}