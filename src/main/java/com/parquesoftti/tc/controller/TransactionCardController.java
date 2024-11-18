package com.parquesoftti.tc.controller;

import com.parquesoftti.tc.model.Transaction;
import com.parquesoftti.tc.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@RestController
@RequestMapping("/api/v1/transaction")

public class TransactionCardController {

    private final TransactionService transactionService;

    @GetMapping()
    public ResponseEntity<List<Transaction>> getTransactionCard(){
        return ResponseEntity.ok().body(transactionService.getTransactions());
    }
//    private final TransactionService transactionService;
//
//    @GetMapping()
//    public ResponseEntity<List<Transaction>> getTransactions(){
//        return ResponseEntity.ok().body(transactionService.getTransactionCards());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Transaction> getTransactionById(
//            @PathVariable Long id){
//        return ResponseEntity.ok().body(transactionService.getTransactionById(id).get());
//    }
//
//    @GetMapping("/transactionsId/{transaction}")
//    public ResponseEntity<Transaction> getTransactionsById(
//            @PathVariable String transaction){
//        return ResponseEntity.ok().body(transactionService.getTransactionByIdTransaction(transaction));
//    }

}
