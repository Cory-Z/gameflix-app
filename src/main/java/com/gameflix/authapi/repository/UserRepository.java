package com.gameflix.authapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gameflix.authapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}