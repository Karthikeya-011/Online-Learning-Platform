package com.learnify.backend.repository;

import com.learnify.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ Custom JPQL query to avoid Spring parsing issues
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    Optional<User> loginUser(@Param("email") String email, @Param("password") String password);
}


