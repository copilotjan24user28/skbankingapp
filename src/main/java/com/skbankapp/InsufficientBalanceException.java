package com.skbankapp;


/*
 * create InsufficientBalanceException class which extends Exception
 */

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}