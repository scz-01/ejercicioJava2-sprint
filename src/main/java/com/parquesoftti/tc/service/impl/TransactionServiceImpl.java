package com.parquesoftti.tc.service.impl;

import com.parquesoftti.tc.model.Transaction;
import com.parquesoftti.tc.repository.TransactionRepository;
import com.parquesoftti.tc.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }


//    @Override
//    public Transaction saveTransaction(Transaction transaction) {
//        return null;
//    }
//
//    private final TransactionRepository transactionRepository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<Transaction> getTransactionCards(){
//        return transactionRepository.findAll();
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<Transaction> getTransactionById(Long id){
//        if (id == null || id <= 0){
//            throw new IllegalArgumentException("El id debe ser positivo y no nulo");
//        }
//        return transactionRepository.findById(id);
//    }
//
//    @Override
//    public Transaction getTransactionByIdTransaction(String transactionId) {
//        return null;
//    }


    // ---------------------------------------------------------------------

//    @Transactional(readOnly = false, rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
//    @Override
//    public Transaction saveTransaction(Transaction transaction){
//        validateTransaction(transaction);
//        return TransactionRepository.save(transaction);
//    }



//    public CreditCard saveCreditCard(CreditCard creditCard) {
//        validateCreditCard(creditCard);
//        return creditCardRepository.save(creditCard);
//    }

    //@Override
//    @Transactional(readOnly = true)
//    public Transaction getTransactionById (String transactionId){
//
//        var tmp1 = transactionRepository.findTransactionByIdTransaction(transactionId);
//
//        if (tmp1.isPresent()) {
//            return tmp1.get();
//        }else {
//            throw new IllegalArgumentException("El numero de transaccion no existe");
//        }
//    }
}
