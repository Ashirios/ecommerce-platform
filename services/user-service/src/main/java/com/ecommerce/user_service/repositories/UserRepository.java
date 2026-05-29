package com.ecommerce.user_service.repositories;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.user_service.entities.User;
import com.ecommerce.user_service.entities.UserStatus;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM users u WHERE u.username=:username or u.email=:email")
    Optional<User> findByUsernameOrEmail(@Param("username") String username, @Param("email") String emial);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Page<User> findByStatus(UserStatus status, Pageable pageable);

    @Query("SELECT u FROM users u WHERE u.status='ACTIVE' ORDER BY u.createdAt DESC")
    List<User> findActiveUsers();
     
}
