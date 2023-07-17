package com.javatechie.validationerrorhandling.repository;


import com.javatechie.validationerrorhandling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int id);
}
