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

    @Override
    @Transactional(readOnly = true)
    public Optional<Transaction> getTransactionById(Long id){
        if (id == null || id <= 0){
            throw new IllegalArgumentException("El campo no puede ser nulo ni ser menor o igual a 0");
        }
        return transactionRepository.findById(id);
    }


    @Transactional(readOnly = false, rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    @Override
    public Transaction savePayment(Transaction transaction){
        validatePayment(transaction);
        return transactionRepository.save(transaction);
    }

    private void validatePayment (Transaction transaction){
        if (transaction == null){
            throw new IllegalArgumentException("el pago no puede ser nulo");
        }

        if (transaction.getAmount() == null ){
            throw new IllegalArgumentException("el monto no puede ser nulo");
        }

        if (transaction.getStatus() == null){
            throw new IllegalArgumentException("debe ingresar el estado del pago (rechazado - pendiente - realizado)");
        }

    }

    @Transactional(readOnly = false, rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    @Override
    public void reversePayment(Long id){
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID debe ser positivo y no nulo.");
        }
        Optional<Transaction> existingPayment = getTransactionById(id);
        if (existingPayment.isEmpty()) {
            throw new RuntimeException("El pago no existe y no se puede eliminar.");
        }
        transactionRepository.deleteById(id);
    }

}
