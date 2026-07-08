package com.example.pay.repository;

import com.example.pay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    ScopedValue<Object> findUserById();
}
