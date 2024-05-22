package com.example.shoppingmall.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long>{
    Optional<User> findByUserId(String userId);
}