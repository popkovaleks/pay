package com.example.pay.entity;

import jakarta.persistence.*;


import java.util.UUID;

@Entity
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double value;

    @ManyToOne
    private User user;

    public Fee () { }

    public Fee(Double value, User user) {
        this.value = value;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getValue() {
        return value;
    }

    public User getUser() {
        return user;
    }
}