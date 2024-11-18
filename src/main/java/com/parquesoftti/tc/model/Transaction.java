package com.parquesoftti.tc.model;

import com.parquesoftti.tc.service.TransactionService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction", schema = "public") // aqui ponemos el nombre que tiene nuestra table en la base da datos

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false, length = 28)
    private String status;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

//    controller -> service -> implementacion -> repositorio -> modelo = arquitectura en capas

//    primero el modelo Transaction.java,
//    sigue el repositorio transactionRepository,
//    seguimos con la interfaz TransactionService
//    por ultimo tenemos la implementacion TransactionServiceImpl por ultimo controller

}
