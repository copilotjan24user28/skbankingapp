package com.skbankapp;

import java.time.LocalDate;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Running main application" );

        Transaction transaction = new Transaction.TransactionBuilder(LocalDate.now(), TransactionType.CREDIT, 1000).build();
        System.out.println(transaction);

        //create an account sb
        SBAccount sbAccount = new SBAccount(123, 1000, LocalDate.now(), 500);
        System.out.println(sbAccount);

        //deposit 1000
        sbAccount.deposit(1000);
        System.out.println(sbAccount);

        //withdraw 500
        try {
            sbAccount.withdraw(500);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    
    }
}
