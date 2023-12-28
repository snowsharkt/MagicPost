package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Transaction;

import java.util.List;

public interface TransactionServices {

    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long id);

    Transaction createTransaction(Transaction transaction);

    Transaction updateTransaction(Transaction transaction);

    void deleteTransactionById(Long id);
}
