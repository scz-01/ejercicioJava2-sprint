package com.parquesoftti.tc.service;

import com.parquesoftti.tc.model.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionService {

    public List<Transaction> getTransactions();

    public Optional<Transaction> getTransactionById(Long id);

    Transaction savePayment (Transaction transaction);

    void reversePayment(Long id);
}