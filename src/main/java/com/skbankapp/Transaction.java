package com.skbankapp;

import java.time.LocalDate;

/*
 * create a enum with DEBIT, CRIDIT and name it as TransactionTYpe
 * Create a Transaction class with the following properties:

 *  date as a object (ex. LocalDate in java)
 *  type as an enum with 'debit' and 'credit'
 *  amount as a double
 */
enum TransactionType {
    DEBIT, CREDIT
}

public class Transaction {
    private LocalDate date;
    private TransactionType type;
    private double amount;

    public Transaction(TransactionBuilder builder) {
        this.date = builder.date;
        this.type = builder.type;
        this.amount = builder.amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    //create a TransactionBuilder class

    public static class TransactionBuilder {
        private LocalDate date;
        private TransactionType type;
        private double amount;

        public TransactionBuilder(LocalDate date, TransactionType type, double amount) {
            this.date = date;
            this.type = type;
            this.amount = amount;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    @Override
    public String toString() {
        return "Transaction [amount=" + amount + ", date=" + date + ", type=" + type + "]";
    }

}
