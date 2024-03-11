package com.example.Labs57.repositories;

import com.example.Labs57.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{
    User findByEmail(String email);
}
