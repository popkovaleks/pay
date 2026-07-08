package com.example.pay.repository;

import com.example.pay.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeeRepository extends JpaRepository<Fee, UUID> {
}
