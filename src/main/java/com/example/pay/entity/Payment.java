package com.example.pay.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private User recipient;

    @OneToOne
    private Fee fee;

    private boolean paid;

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Payment() {    }

    public Payment(double amount, User user, User recipient, Fee fee) {
        this.amount = amount;
        this.user = user;
        this.recipient = recipient;
        this.fee = fee;
        this.paid = false;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
