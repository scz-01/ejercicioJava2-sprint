package com.parquesoftti.tc.model;

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
@Table(name = "Transaction") // aqui ponemos el nombre que tiene nuestra table en la base da datos
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

//    @Column(nullable = false)
//    private Long credit_card_id;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

}
