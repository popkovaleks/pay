package com.example.pay.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private long amount;

    private long fee;

    private long totalAmount;

    @ManyToOne
    private User user;

    @ManyToOne
    private User recipient;

    private boolean paid;

    public Payment() {    }

    public Payment(long amount, User user, User recipient, long fee) {
        this.amount = amount;
        this.user = user;
        this.recipient = recipient;
        this.fee = fee;
        this.totalAmount = amount + fee;
        this.paid = false;
    }
}
